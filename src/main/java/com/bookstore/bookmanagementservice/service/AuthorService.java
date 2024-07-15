package com.bookstore.bookmanagementservice.service;

import com.bookstore.bookmanagementservice.exception.AuthorException;
import com.bookstore.bookmanagementservice.payload.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createNewAuthor(AuthorDto Author);
    AuthorDto getAuthorById(Integer id);
    void deleteAuthorById(Integer id) throws AuthorException;
    AuthorDto updateAuthorById(Integer id, AuthorDto Author);
}
