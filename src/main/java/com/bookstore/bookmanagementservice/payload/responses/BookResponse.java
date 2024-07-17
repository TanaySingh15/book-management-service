package com.bookstore.bookmanagementservice.payload.responses;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookResponse {
    private Integer id;
    private String bookTitle;
    private String author;
    private String genre;
    private String isbn;
    private Integer stock;
}
