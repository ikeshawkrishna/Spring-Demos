package com.org.DockerDemo.Controller;

import com.org.DockerDemo.Student;
import com.org.DockerDemo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonController {


    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
       return studentRepo.save(student);
    }


    @GetMapping("/getAllStudents")
    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
}
