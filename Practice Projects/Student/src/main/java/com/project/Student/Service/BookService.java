package com.project.Student.Service;

import com.project.Student.Model.Book;
import com.project.Student.Repo.BookRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    RedisService redisService;

    @PostConstruct
    public void loadMasterData() {
        // Example: Add some static data
        try {
            Map<String, Object> studentTypes = new HashMap<>();
            studentTypes.put("UG", "Undergraduate");
            studentTypes.put("PG", "Postgraduate");
            studentTypes.put("PhD", "Doctorate");

            redisTemplate.opsForHash().put("thisiskey","hashkey","value");
            redisTemplate.opsForHash().putAll("studentTypeshash", studentTypes);
            redisTemplate.opsForValue().set("studentTypesvalue", studentTypes);

            System.out.println("Master data loaded into Redis.");
            System.out.println(redisTemplate.opsForHash().values("studentTypeshash"));
            System.out.println(redisTemplate.opsForHash().entries("studentTypeshash"));
            System.out.println(redisTemplate.opsForHash().entries("thisiskey"));
            System.out.println(redisTemplate.opsForHash().values("thisiskey"));
            System.out.println(redisTemplate.opsForHash().values("hashkey"));

            System.out.println(redisTemplate.opsForValue().get("studentTypesvalue"));

        } catch (Exception e) {
            System.out.println("Exception occurred......");
        }

    }


//    @Cacheable(key = "#id",value = "booksvalue")
    public ResponseEntity<?> getAllBooks() {
        List<Book> all = bookRepo.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Cacheable(key = "#id", value = "Book")
    public Book findBookById(Long id){
        Book byId = bookRepo.findById(id).orElseThrow(() -> new RuntimeException());
        return byId;
    }

    public Book addBooks(Book book) {
        Book save = bookRepo.save(book);
        return save;
    }

    @CachePut(key = "#id",value = "Book")
    public Book updateBook(Book book, Long id) {
        Book book1 = bookRepo.findById(id).orElseThrow(() -> new RuntimeException());
        book.setId(id);
        Book save = bookRepo.save(book);
        return save;
    }

    @CacheEvict(key = "#id",value = "Book")
    public String deleteBook(Book book) {
        bookRepo.delete(book);
        return "Success";
    }
}
