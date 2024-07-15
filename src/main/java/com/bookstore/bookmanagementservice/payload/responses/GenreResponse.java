package com.bookstore.bookmanagementservice.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

@Data
@AllArgsConstructor
public class GenreResponse {
    private String genre;
    private Set<String> books;
}
