package com.example.JPAApplication.Service;

import com.example.JPAApplication.Model.Applicant;
import com.example.JPAApplication.Repo.ApplicantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService implements ApplicantServiceImpl{

    @Autowired
    ApplicantRepo applicantRepo;

    @Override
    public List<Applicant> findAll() {
        return applicantRepo.findAll();
    }
}
