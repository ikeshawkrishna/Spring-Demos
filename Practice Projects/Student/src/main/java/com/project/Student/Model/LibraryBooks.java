package com.project.Student.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "LibraryBooks")
public class LibraryBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookname;

    private String bookAuthor;

    private int bookPrice;

    @ManyToOne
    @JoinColumn(name = "student_fk", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Student student;

}
