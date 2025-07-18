package com.utkarsh.bookstore.service;

import java.util.List;

import com.utkarsh.bookstore.model.Author;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author createAuthor(Author author);
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
}
