package com.bookstore.bookmanagementservice.payload.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class GenreDto {
    Integer bookId;
    String name;
    BookDto book;
}
