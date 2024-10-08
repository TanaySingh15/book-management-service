package com.bookstore.bookmanagementservice.service;


import com.bookstore.bookmanagementservice.exception.AuthorException;
import com.bookstore.bookmanagementservice.exception.GenreException;
import com.bookstore.bookmanagementservice.payload.dto.BookDto;

public interface BookService {
    BookDto createNewBook(BookDto book) throws AuthorException, GenreException;
    BookDto getBookById(Integer id);
    void deleteBookById(Integer id);
    BookDto updateBookById(Integer id, BookDto book);
}
