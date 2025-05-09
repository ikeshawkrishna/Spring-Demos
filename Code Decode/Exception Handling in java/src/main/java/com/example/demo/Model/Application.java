package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sno")
    private Long Sno;

    private String skills;

    @ManyToOne
    @JoinColumn(name = "applicant_fk", nullable = false, referencedColumnName = "Sno")
    @JsonIgnore
    private Applicant applicant;
}
