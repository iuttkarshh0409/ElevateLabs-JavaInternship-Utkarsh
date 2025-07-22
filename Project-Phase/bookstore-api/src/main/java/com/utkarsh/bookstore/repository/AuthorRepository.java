package com.utkarsh.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utkarsh.bookstore.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Optional: Add custom query methods here
}
