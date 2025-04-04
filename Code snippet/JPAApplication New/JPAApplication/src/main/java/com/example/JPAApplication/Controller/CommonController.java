package com.example.JPAApplication.Controller;


import com.example.JPAApplication.Configuration.TM_Programmatic_approach1;
import com.example.JPAApplication.Model.Applicant;
import com.example.JPAApplication.Model.Application;
import com.example.JPAApplication.Model.Resume;
import com.example.JPAApplication.Repo.ApplicantRepo;
import com.example.JPAApplication.Repo.ResumeRepo;

import com.example.JPAApplication.Service.ApplicantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    ApplicantRepo applicantRepo;

    @Autowired
    ResumeRepo resumeRepo;

    @Autowired
    TM_Programmatic_approach1 tmProgrammaticApproach1;

    @Autowired
    ApplicantServiceImpl ApplicantServiceImpl;

    @GetMapping("/getAllApplicants")
    public List<Applicant> getAllApplicants(){
        return ApplicantServiceImpl.findAll();
    }

    @PostMapping("/saveApplicant")
    public Applicant saveApplicant(@RequestBody Applicant applicant){
        List<Application> applicationsList = applicant.getApplicationsList();
        applicationsList.forEach(
                application -> {
                    application.setApplicant(applicant);
                }
        );
        Resume resume = applicant.getResume();
        boolean status = tmProgrammaticApproach1.UpdateUser(() -> {
            applicantRepo.save(applicant);
        });

        return status ? applicant : new Applicant();
    }

    @PostMapping("saveResumeById")
    public Resume saveResume( @RequestBody Resume resume){
        Applicant applicant = resume.getApplicant();
        if(applicant != null){
            applicant.setResume(resume);
        }
        return resumeRepo.save(resume);
    }

    @Transactional(propagation = Propagation.REQUIRED) // Starts Transaction T1
    public void methodA() {
        updateQuery1();  // Part of T1
        methodB();       // Runs inside a savepoint (Nested Transaction)
        updateQuery2();  // Still part of T1
    }

    @Transactional(propagation = Propagation.NESTED)
    public void methodB() {
        insertQuery();  // Runs inside a savepoint
    }

    private void insertQuery() {
    }
    private void updateQuery2() {
    }
    private void updateQuery1() {
    }

}
