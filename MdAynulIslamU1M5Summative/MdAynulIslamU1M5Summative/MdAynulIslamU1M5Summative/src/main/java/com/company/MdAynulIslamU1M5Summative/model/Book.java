package com.company.MdAynulIslamU1M5Summative.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Book {

    //properties of book table using Camel case

    private int bookId;// auto increment PK
    private String isbn;
    private LocalDate publishDate; // Local Date class
    private int authorId;// FK from author table
    private String title;
    private int publisherId;// FK from publisher table
    private BigDecimal price;

    //Getters and Setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    //equal and Hashcode
    // selecting all the fields that must not be null


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                authorId == book.authorId &&
                publisherId == book.publisherId &&
                isbn.equals(book.isbn) &&
                publishDate.equals(book.publishDate) &&
                title.equals(book.title) &&
                price.equals(book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, publishDate, authorId, title, publisherId, price);
    }
}
