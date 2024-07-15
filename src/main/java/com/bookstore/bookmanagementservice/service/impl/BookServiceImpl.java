package com.bookstore.bookmanagementservice.service.impl;

import com.bookstore.bookmanagementservice.payload.dto.BookDto;
import com.bookstore.bookmanagementservice.payload.responses.BookListResponse;
import com.bookstore.bookmanagementservice.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public BookDto createNewBook(BookDto book) {
        return null;
    }

    @Override
    public BookDto getBookById(Integer id) {
        return null;
    }

    @Override
    public void deleteBookById(Integer id) {

    }

    @Override
    public BookDto updateBookById(Integer id, BookDto book) {
        return null;
    }
}
