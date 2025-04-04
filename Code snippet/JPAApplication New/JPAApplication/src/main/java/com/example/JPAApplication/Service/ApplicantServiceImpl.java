package com.example.JPAApplication.Service;

import com.example.JPAApplication.Model.Applicant;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ApplicantServiceImpl {
    public List<Applicant> findAll() ;
}
