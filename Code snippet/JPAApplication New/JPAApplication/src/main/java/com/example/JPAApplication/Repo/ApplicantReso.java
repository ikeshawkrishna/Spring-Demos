package com.example.JPAApplication.Repo;

import com.example.JPAApplication.JpaApplication;
import com.example.JPAApplication.Model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantReso  extends JpaRepository<Applicant, Long> {
}
