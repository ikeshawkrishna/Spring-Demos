package com.project.Student.Controller;

import com.project.Student.Model.Book;
import com.project.Student.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/getAllBooks")
    public ResponseEntity<?> getAllBooks(){
        ResponseEntity<?> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    @GetMapping("/findBookById/{id}")
    public ResponseEntity<?> findBookById(@PathVariable("id") Long id){
        Book bookById = bookService.findBookById(id);
        return new ResponseEntity<Book>(bookById, HttpStatus.OK);
    }

    @PostMapping("/addBooks")
    public ResponseEntity<?> addBooks(@RequestBody Book book){
        Book book1 = bookService.addBooks(book);
        return new ResponseEntity<>(book1,HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<?> updateBook(@RequestBody Book book,@PathVariable Long id){
        Book book1 = bookService.updateBook(book, id);
        return new ResponseEntity<>(book1,HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<?> deleteBook(@RequestBody Book book){
        String s = bookService.deleteBook(book);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
}
