package com.utkarsh.bookstore.repository;

import com.utkarsh.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor; // <-- IMPORT THIS
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> { // <-- ADD THIS
    // No need to add custom methods here for this feature
}