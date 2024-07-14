package com.bookstore.bookmanagementservice.payload.dto;

import com.bookstore.bookmanagementservice.entity.Author;
import com.bookstore.bookmanagementservice.entity.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    Integer bookId;
    String title;
    String isbn;
    Integer stock;
    Timestamp created_date;
    Timestamp updated_date;
    AuthorDto author;
    GenreDto genre;
}
