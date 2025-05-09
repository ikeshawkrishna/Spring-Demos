package com.project.Student.Repo;

import com.project.Student.Model.AdmissionForm;
import com.project.Student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionFormRepo extends JpaRepository<AdmissionForm, Long> {
}
