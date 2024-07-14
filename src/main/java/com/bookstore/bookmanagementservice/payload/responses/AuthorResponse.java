package com.bookstore.bookmanagementservice.payload.responses;

import lombok.Data;

import java.util.Set;

@Data
public class AuthorResponse {

    String authorName;
    Set<String> books;
}
