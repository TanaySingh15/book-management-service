package com.bookstore.bookmanagementservice.payload.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class AuthorDto {
    Integer authorId;
    String name;
    Set<BookDto> books;
}
