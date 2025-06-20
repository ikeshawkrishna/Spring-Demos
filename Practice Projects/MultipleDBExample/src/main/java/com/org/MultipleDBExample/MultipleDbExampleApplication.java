package com.org.MultipleDBExample;

import com.org.MultipleDBExample.Model.Book.Book;
import com.org.MultipleDBExample.Model.User.User;
import com.org.MultipleDBExample.Repo.Book.BookRepository;
import com.org.MultipleDBExample.Repo.User.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@ResponseBody
public class MultipleDbExampleApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @PostConstruct
    public void saveData(){
        List<User> list = Arrays.asList(
                new User("keshaw", 23),
                new User("shaw", 23));

        List<Book> bookList = Arrays.asList(
                new Book("secret", 25.0),
                new Book("Redemption", 23.0)
        );

        userRepository.saveAll(list);
        bookRepository.saveAll(bookList);
    }

    @GetMapping("/getUser")
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @GetMapping("/getUser")
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(MultipleDbExampleApplication.class, args);

    }

}
