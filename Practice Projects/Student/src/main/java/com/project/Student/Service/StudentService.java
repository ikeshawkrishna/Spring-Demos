package com.project.Student.Service;

import com.project.Student.Exceptions.StudentNotFound;
import com.project.Student.Model.AdmissionForm;
import com.project.Student.Model.LibraryBooks;
import com.project.Student.Model.Student;
import com.project.Student.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student addStudent(Student student) {
        student.getAdmissionForm().setStudent(student);
        List<LibraryBooks> libraryBooks = student.getLibraryBooks();
        for(LibraryBooks books : libraryBooks){
            books.setStudent(student);
        }
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student updateStudent(Long id, Student student) throws Exception{
        Student studentFound = studentRepo.findById(id).orElseThrow(() -> new StudentNotFound( "Student Not found"));
        studentFound.setAge(student.getAge());
        studentFound.setFirstname(student.getFirstname());
        studentFound.setLastname(student.getLastname());
        studentFound.setMiddlename(student.getMiddlename());
        studentFound.setSkills(student.getSkills());
        return studentRepo.save(studentFound);

    }
}
