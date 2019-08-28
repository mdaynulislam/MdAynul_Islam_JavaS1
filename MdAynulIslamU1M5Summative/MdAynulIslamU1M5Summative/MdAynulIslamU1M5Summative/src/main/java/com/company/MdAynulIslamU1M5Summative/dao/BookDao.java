package com.company.MdAynulIslamU1M5Summative.dao;

import com.company.MdAynulIslamU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {

    //create, read, readAll, update, delete and find by author method for book

    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBook(int id);

    List<Book> getBookByAuthor(int authorId);

}
