package com.bookstore.bookmanagementservice.service;


import com.bookstore.bookmanagementservice.payload.dto.BookDto;
import com.bookstore.bookmanagementservice.payload.responses.BookListResponse;

import java.util.List;

public interface BookService {
    BookDto createNewBook(BookDto book);
    List<BookListResponse> getAllBooks();
    BookDto getBookById(Integer id);
    void deleteBookById(Integer id);
    BookDto updateBookById(Integer id, BookDto book);
}
