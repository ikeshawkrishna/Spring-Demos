package com.project.Student.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stduent_seq_generator")
    @SequenceGenerator(name = "stduent_seq_generator",allocationSize = 1)
    private Long id;

    @Column(name = "Firstname", nullable = false)
    private String firstname;

    @Column(name = "MiddleName")
    private String middlename;

    @Column(name = "LastName")
    private String lastname;

    @Column(name = "Age")
    private int age;

    @Column(name = "Skills")
    private List<String> skills;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admissionForm_FK", referencedColumnName = "id", nullable = false)
    private AdmissionForm admissionForm;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<LibraryBooks> libraryBooks;
}
