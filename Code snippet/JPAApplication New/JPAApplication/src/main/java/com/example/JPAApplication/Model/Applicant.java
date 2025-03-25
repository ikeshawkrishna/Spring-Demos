package com.example.JPAApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private long id;

    private String name;

    private int age;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_fk", referencedColumnName = "id", nullable = false)
    private Resume resume;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")
    @Column(name = "appList")
    private List<Application> applicationsList = new ArrayList<>();

}
