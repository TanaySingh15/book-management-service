package com.bookstore.bookmanagementservice.payload.dto;

import com.bookstore.bookmanagementservice.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class GenreDto {
    Integer bookId;
    String name;
    Book book;
}
