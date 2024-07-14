package com.bookstore.bookmanagementservice.service;

import com.bookstore.bookmanagementservice.payload.dto.AuthorDto;
import com.bookstore.bookmanagementservice.payload.responses.AuthorListResponse;

import java.util.List;

public interface AuthorService {
    AuthorDto createNewAuthor(AuthorDto Author);
    List<AuthorListResponse> getAllAuthors();
    AuthorDto getAuthorById(Integer id);
    void deleteAuthorById(Integer id);
    AuthorDto updateAuthorById(Integer id, AuthorDto Author);
}
