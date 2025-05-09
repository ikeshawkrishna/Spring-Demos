package com.project.Student.Controller;

import com.project.Student.Exceptions.ErrorResponse;
import com.project.Student.Model.Student;
import com.project.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return  ResponseEntity.ok(allStudents);
    }

    @PutMapping("{studid}/updateStudent")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "studid") Long id, @RequestBody Student student) throws Exception {
        Student student1 = null;
        try{
            student1 = studentService.updateStudent(id, student);
        } catch (Exception e){
            return new ResponseEntity<ErrorResponse>(
                    new ErrorResponse("101",e.getMessage()),HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(student1);
    }

}
