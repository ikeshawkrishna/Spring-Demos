package com.example.JPAApplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    private String description;


    @ManyToOne
    @JoinColumn(name = "applicant_fk", referencedColumnName = "applicant_id")
    @JsonIgnore
    private Applicant applicant;
}
