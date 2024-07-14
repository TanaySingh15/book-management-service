package com.bookstore.bookmanagementservice.service.impl;

import com.bookstore.bookmanagementservice.payload.dto.AuthorDto;
import com.bookstore.bookmanagementservice.payload.responses.AuthorListResponse;
import com.bookstore.bookmanagementservice.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public AuthorDto createNewAuthor(AuthorDto Author) {
        return null;
    }

    @Override
    public List<AuthorListResponse> getAllAuthors() {
        return List.of();
    }

    @Override
    public AuthorDto getAuthorById(Integer id) {
        return null;
    }

    @Override
    public void deleteAuthorById(Integer id) {

    }

    @Override
    public AuthorDto updateAuthorById(Integer id, AuthorDto Author) {
        return null;
    }
}
