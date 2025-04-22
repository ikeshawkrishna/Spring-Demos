package com.example.Security.Controller;

import com.example.Security.Entity.Users;
import com.example.Security.Model.Student;
import com.example.Security.Service.UserRegistryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommonController {

    @Autowired
    UserRegistryService userRegistryService;

    List<Student> studentList = new ArrayList<>(List.of(
            new Student(23,"Keshaw","Spring Boot"),
            new Student(24,"Krihna","Devops")
    ));

    @GetMapping("home")
    public String getHome(HttpServletRequest request){
        return "hello world >> " + request.getSession().getId();
    }

    @GetMapping("getStudent")
    public List<Student> getStudents(){
        return studentList;
    }

    @PostMapping("addStudent")
    public void addStudents(@RequestBody Student student){
        studentList.add(student);
    }

    @GetMapping("token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("userRegistry")
    public Users userRegistry(@RequestBody Users user){
        return userRegistryService.userRegistry(user);
    }
}
