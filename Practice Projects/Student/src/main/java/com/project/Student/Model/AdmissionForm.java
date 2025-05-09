package com.project.Student.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AdmissionForm")
@Data
public class AdmissionForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admission_seq_generator")
    @SequenceGenerator(name = "admission_seq_generator",allocationSize = 1)
    private Long id;

    private String studentName;

    private String classGrade;

    private String address;

    @OneToOne(mappedBy = "admissionForm")
    @JsonIgnore
    private Student student;

}
