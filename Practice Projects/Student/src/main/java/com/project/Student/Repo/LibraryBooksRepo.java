package com.project.Student.Repo;

import com.project.Student.Model.LibraryBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBooksRepo extends JpaRepository<LibraryBooks, Long> {
}
