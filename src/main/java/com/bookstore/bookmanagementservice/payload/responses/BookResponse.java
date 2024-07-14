package com.bookstore.bookmanagementservice.payload.responses;


import lombok.Data;

@Data
public class BookResponse {
    private String bookTitle;
    private String author;
    private String genre;
    private String isbn;
    private Integer stock;
}
