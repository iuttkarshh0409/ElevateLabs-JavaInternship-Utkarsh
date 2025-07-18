package com.utkarsh.bookstore.model;

import java.math.BigDecimal; // This annotation breaks the loop
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private String isbn;
    private BigDecimal price;
    private LocalDate publishedDate;
    
    // This field is for receiving the author's ID from the frontend.
    @Transient 
    private Long authorId;

    // This tells Jackson to ignore this side during serialization to prevent an infinite loop.
    @ManyToOne(fetch = FetchType.LAZY) // LAZY is correct here
    @JoinColumn(name = "author_id", nullable = false)
    @JsonBackReference
    private Author author;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public LocalDate getPublishedDate() { return publishedDate; }
    public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    public Long getAuthorId() {
        if (author != null) {
            return author.getId();
        }
        return authorId;
    }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
}