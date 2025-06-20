package com.org.MultipleDBExample.Repo.Book;

import com.org.MultipleDBExample.Model.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
