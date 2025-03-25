package com.example.JPAApplication.Repo;

import com.example.JPAApplication.Model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Long> {
}
