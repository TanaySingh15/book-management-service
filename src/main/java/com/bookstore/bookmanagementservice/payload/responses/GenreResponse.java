package com.bookstore.bookmanagementservice.payload.responses;

import lombok.Data;
import java.util.Set;

@Data
public class GenreResponse {
    private String genre;
    private Set<String> books;
}
