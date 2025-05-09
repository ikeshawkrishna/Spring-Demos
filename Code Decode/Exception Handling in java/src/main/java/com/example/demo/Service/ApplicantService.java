package com.example.demo.Service;

import com.example.demo.Exception.DataNotFoundException;
import com.example.demo.Model.Applicant;
import com.example.demo.Model.Application;
import com.example.demo.Model.Resume;
import com.example.demo.Repo.ApplicantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    @Autowired
    ApplicantRepo applicantRepo;

    public List<Applicant> getApplicants() {
        return applicantRepo.findAll();
    }

//    @Transactional("setTransactionManagerCustom")
    public Applicant addApplicant(Applicant applicant) {
            List<Application> applicationList = applicant.getApplication();
            applicationList.forEach(applicatiion -> {
                applicatiion.setApplicant(applicant);
            });
            applicantRepo.save(applicant);

            return applicantRepo.save(applicant);
    }

    public List<Applicant> getApplicantByName(String name) {
       return applicantRepo.findByName(name);
    }

    @Transactional
    public Applicant updateApplicantNameById(Long id, String name) {
        Optional<Applicant> byId = applicantRepo.findById(id);
        if(byId.isEmpty()){
            throw new DataNotFoundException("Requested Id is invalid...");
        }
        Applicant applicant = byId.get();
        applicant.setName(name);
        return applicantRepo.save(applicant);
    }
}
