package com.bookstore.bookmanagementservice.controllers;

import com.bookstore.bookmanagementservice.exception.AuthorException;
import com.bookstore.bookmanagementservice.payload.dto.AuthorDto;
import com.bookstore.bookmanagementservice.payload.responses.ApiResponse;
import com.bookstore.bookmanagementservice.payload.responses.AuthorResponse;
import com.bookstore.bookmanagementservice.service.impl.AuthorServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController("/api/author/")
public class AuthorController {

    @Resource
    private AuthorServiceImpl authorService;

    @PostMapping
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto newAuthor = authorService.createNewAuthor(authorDto);
        Set<String> books = new HashSet<>();
        newAuthor.getBooks().forEach(book -> books.add(book.getTitle()));
        AuthorResponse authorResponse = new AuthorResponse(newAuthor.getName(), books);
        return new ResponseEntity<>(authorResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AuthorResponse> updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable Integer id) {
        AuthorDto updateAuthor = authorService.updateAuthorById(id, authorDto);
        Set<String> books = new HashSet<>();
        updateAuthor.getBooks().forEach(book -> books.add(book.getTitle()));
        AuthorResponse authorResponse = new AuthorResponse(updateAuthor.getName(), books);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteAuthor(@RequestBody AuthorDto authorDto, @PathVariable Integer id) throws AuthorException {
        authorService.deleteAuthorById(id);
        ApiResponse apiResponse = new ApiResponse("Successfully Deleted", HttpStatus.OK);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Integer id) {
        AuthorDto getAuthor = authorService.getAuthorById(id);
        Set<String> books = new HashSet<>();
        getAuthor.getBooks().forEach(book -> books.add(book.getTitle()));
        AuthorResponse authorResponse = new AuthorResponse(getAuthor.getName(), books);
        return new ResponseEntity<>(authorResponse, HttpStatus.FOUND);
    }
}
