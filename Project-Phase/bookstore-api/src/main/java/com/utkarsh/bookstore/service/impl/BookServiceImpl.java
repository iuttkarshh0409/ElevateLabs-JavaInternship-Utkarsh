package com.utkarsh.bookstore.service.impl;

import com.utkarsh.bookstore.exception.ResourceNotFoundException;
import com.utkarsh.bookstore.model.Author;
import com.utkarsh.bookstore.model.Book;
import com.utkarsh.bookstore.repository.AuthorRepository;
import com.utkarsh.bookstore.repository.BookRepository;
import com.utkarsh.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;         // <-- IMPORT THIS
import org.springframework.data.domain.Pageable;       // <-- IMPORT THIS
import org.springframework.data.jpa.domain.Specification; // <-- IMPORT THIS
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Book> getAllBooks(Specification<Book> spec, Pageable pageable) { // <-- MODIFY THIS METHOD
        return bookRepository.findAll(spec, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        Long authorId = book.getAuthorId();
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot create book: Author not found with ID: " + authorId));
        
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book updateBook(Long id, Book bookDetails) {
        Book existingBook = getBookById(id);

        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setIsbn(bookDetails.getIsbn());
        existingBook.setGenre(bookDetails.getGenre());
        existingBook.setPrice(bookDetails.getPrice());
        existingBook.setPublishedDate(bookDetails.getPublishedDate());

        Long authorId = bookDetails.getAuthorId();
        if (authorId != null) {
             Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot update book: Author not found with ID: " + authorId));
             existingBook.setAuthor(author);
        }

        return bookRepository.save(existingBook);
    }
    
    @Override
    @Transactional
    public boolean deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            return false;
        }
        bookRepository.deleteById(id);
        return true;
    }
}