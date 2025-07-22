package com.utkarsh.bookstore.service;

import com.utkarsh.bookstore.model.Book;
import org.springframework.data.domain.Page;         // <-- IMPORT THIS
import org.springframework.data.domain.Pageable;       // <-- IMPORT THIS
import org.springframework.data.jpa.domain.Specification; // <-- IMPORT THIS

/**
 * Service interface for managing books.
 * This defines the contract for business logic operations related to books.
 */
public interface BookService {

    /**
     * Retrieves a paginated and filtered list of all books.
     * @param spec The specification to filter the books (can be null).
     * @param pageable The pagination and sorting information.
     * @return a page of {@link Book} objects.
     */
    Page<Book> getAllBooks(Specification<Book> spec, Pageable pageable); // <-- MODIFY THIS LINE

    /**
     * Finds a book by its unique ID.
     * @param id The ID of the book to find.
     * @return the found {@link Book} object.
     * @throws com.utkarsh.bookstore.exception.ResourceNotFoundException if no book is found with the given ID.
     */
    Book getBookById(Long id);

    /**
     * Creates and saves a new book.
     * @param book The {@link Book} object to create.
     * @return the created {@link Book} object with its generated ID.
     */
    Book createBook(Book book);

    /**
     * Updates the details of an existing book.
     * @param id The ID of the book to update.
     * @param bookDetails A {@link Book} object containing the new details.
     * @return the updated {@link Book} object.
     * @throws com.utkarsh.bookstore.exception.ResourceNotFoundException if no book is found with the given ID.
     */
    Book updateBook(Long id, Book bookDetails);

    /**
     * Deletes a book by its ID.
     * @param id The ID of the book to delete.
     * @return true if the book was found and deleted, false otherwise.
     */
    boolean deleteBook(Long id);
}