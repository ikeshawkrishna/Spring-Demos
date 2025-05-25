package com.project.Student.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.project.Student.Model.Book;
import com.project.Student.Repo.BookRepo;
import jakarta.annotation.PostConstruct;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    RedisService redisService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void BookServicePostContruct() {
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

            loadROIMasterData();
            List<Map<String, Object>> olist = (List<Map<String, Object>>) redisTemplate.opsForValue().get("roi:master");
            System.out.println("oooooo  >>> " + olist);

            olist.forEach((element) -> {
//                if(element.get("scheme").toString().equalsIgnoreCase("pmvk")){
//                    int tenormin = (int) element.get("tenormin");
//                    int tenormax = (int) element.get("tenormax");
//                    System.out.println("tenormin >> " + tenormin + " tenormax >> " + tenormax);
//                }
            });

            System.out.println(redisTemplate.opsForValue().get("Book"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadROIMasterData(){
        String sql = "SELECT * FROM dbo.msme_roi_master";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        redisTemplate.opsForValue().set("roi:master",maps);
    }


//    @Cacheable(value = "booksvalue")
    public ResponseEntity<?> getAllBooks() {
        List<Book> all = bookRepo.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Cacheable(key = "#id", value = "Bookable")
    public Book findBookById(Long id){
        Book byId = bookRepo.findById(id).orElseThrow(() -> new RuntimeException());
        return byId;
    }

    public Book addBooks(Book book) {
        Book save = bookRepo.save(book);
        return save;
    }

    @CachePut(key = "#id",value = "Bookable")
    public Book updateBook(Book book, Long id) {
        Book book1 = bookRepo.findById(id).orElseThrow(() -> new RuntimeException());
        book.setId(id);
        Book save = bookRepo.save(book);
        return save;
    }

    @CacheEvict(key = "#book.id",value = "Bookable")
    public String deleteBook(Book book) {
        bookRepo.delete(book);
        return "Success";
    }


    public JSONObject validateHeader(JSONObject inputHeader){
        JSONObject jobj = new JSONObject();
        try{
            Map<String, String> headers = new HashMap<>();
            headers.put("1","ClientId");
            headers.put("2","Clientname");
            headers.put("3","secretkey");
            headers.put("4","token");

            for(Map.Entry<String, String> map : headers.entrySet()){
                if(inputHeader.getString(map.getValue().toString()).isEmpty()){
                    jobj.put("status","Failed");
                    return jobj;
                }
            }

            jobj.put("status","Success");

        } catch (Exception e){
            e.printStackTrace();
            jobj.put("status","Exception");
        }
        return jobj;
    }


}
