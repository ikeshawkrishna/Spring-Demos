package com.example.demo.Controller;

import com.example.demo.Exception.DataNotFoundException;
import com.example.demo.Exception.ErrorResponse;
import com.example.demo.Model.Applicant;
import com.example.demo.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommonController {

    @Autowired
    ApplicantService applicantService;

    @GetMapping("/getApplicants")
    public List<Applicant> getApplicants(){
        return applicantService.getApplicants();
    }

    @PostMapping("/addApplicant")
    public Applicant addApplicant(@RequestBody Applicant applicant){
        return applicantService.addApplicant(applicant);
    }

    @GetMapping("/getApplicantByName")
    public List<Applicant> getApplicantByName(@RequestParam("name") String name){
        return applicantService.getApplicantByName(name);
    }

    @PostMapping("updateApplicantNameById/{appId}")
    public ResponseEntity<?> updateApplicantNameById(@PathVariable("appId") Long id, @RequestParam("name") String name){
        Applicant applicant = null;
        try{
            applicant = applicantService.updateApplicantNameById(id, name);
        } catch (DataNotFoundException e){
            return new ResponseEntity<ErrorResponse>(
                    new ErrorResponse("101",e.getMessage(),e.getLocalizedMessage()),
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<Applicant>(applicant, HttpStatus.OK);
    }

}
