package com.utkarsh.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarsh.bookstore.exception.ResourceNotFoundException;
import com.utkarsh.bookstore.model.Author;
import com.utkarsh.bookstore.repository.AuthorRepository;
import com.utkarsh.bookstore.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = getAuthorById(id);
        author.setName(authorDetails.getName());
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }
}
