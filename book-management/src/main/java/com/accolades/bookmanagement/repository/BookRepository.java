package com.accolades.bookmanagement.repository;

import com.accolades.bookmanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
