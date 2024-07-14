package com.bookstore.bookmanagementservice.controllers;


import com.bookstore.bookmanagementservice.payload.dto.BookDto;
import com.bookstore.bookmanagementservice.payload.responses.BookResponse;
import com.bookstore.bookmanagementservice.service.impl.BookServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/books/")
public class BookController {

    private BookServiceImpl bookService;

}
