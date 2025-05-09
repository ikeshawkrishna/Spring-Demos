package com.example.demo.Repo;

import com.example.demo.Model.Applicant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Long> {
    @Query("SELECT a FROM Applicant a WHERE a.name = :name")
    List<Applicant> findByName(@Param("name") String name);

}
