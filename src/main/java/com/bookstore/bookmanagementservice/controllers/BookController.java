package com.bookstore.bookmanagementservice.controllers;

import com.bookstore.bookmanagementservice.exception.AuthorException;
import com.bookstore.bookmanagementservice.exception.GenreException;
import com.bookstore.bookmanagementservice.payload.dto.BookDto;
import com.bookstore.bookmanagementservice.payload.responses.ApiResponse;
import com.bookstore.bookmanagementservice.payload.responses.BookResponse;
import com.bookstore.bookmanagementservice.service.impl.BookServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Resource
    private BookServiceImpl bookService;

    @PostMapping("/create")
    public ResponseEntity<BookResponse> addBook(@RequestBody BookDto bookDto) throws AuthorException, GenreException {
        BookDto newBook = bookService.createNewBook(bookDto);
        BookResponse bookResponse = new BookResponse(newBook.getBookId(), newBook.getTitle(), newBook.getAuthor().getName(), newBook.getGenre().getName(), newBook.getIsbn(), newBook.getStock());
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponse> updateBook(@RequestBody BookDto bookDto, @PathVariable Integer id) {
        BookDto newBook = bookService.updateBookById(id, bookDto);
        BookResponse bookResponse = new BookResponse(newBook.getBookId(),newBook.getTitle(), newBook.getAuthor().getName(), newBook.getGenre().getName(), newBook.getIsbn(), newBook.getStock());
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        ApiResponse apiResponse = new ApiResponse("Successfully Deleted", HttpStatus.OK);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Integer id) {
        BookDto newBook = bookService.getBookById(id);
        BookResponse bookResponse = new BookResponse(newBook.getBookId(), newBook.getTitle(), newBook.getAuthor().getName(), newBook.getGenre().getName(), newBook.getIsbn(), newBook.getStock());
        return new ResponseEntity<>(bookResponse, HttpStatus.FOUND);
    }

}
