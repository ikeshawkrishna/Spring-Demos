package com.project.Student.Service;

import com.project.Student.Exceptions.StudentNotFound;
import com.project.Student.Model.LibraryBooks;
import com.project.Student.Model.Student;
import com.project.Student.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<LibraryBooks> libraryBooks = student.getLibraryBooks();
        for(LibraryBooks books : libraryBooks){
            books.setStudent(student);
        }
        student.setId(id);
        return studentRepo.save(student);

    }
}
