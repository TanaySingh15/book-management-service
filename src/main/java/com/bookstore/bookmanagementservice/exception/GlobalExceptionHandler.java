package com.bookstore.bookmanagementservice.exception;

import com.bookstore.bookmanagementservice.payload.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        ApiResponse response = new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorException.class)
    public ResponseEntity<ApiResponse> authorException(AuthorException ex) {
        ApiResponse response = new ApiResponse("Unable to delete author as he has books associated to him", HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(GenreException.class)
    public ResponseEntity<ApiResponse> genreException(GenreException ex) {
        ApiResponse response = new ApiResponse("Unable to delete genre as it has books associated to him", HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}