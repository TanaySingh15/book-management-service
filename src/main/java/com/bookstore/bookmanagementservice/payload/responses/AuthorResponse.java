package com.bookstore.bookmanagementservice.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AuthorResponse {

    String authorName;
    Set<String> books;
}
