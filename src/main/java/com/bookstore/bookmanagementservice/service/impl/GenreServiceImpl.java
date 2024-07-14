package com.bookstore.bookmanagementservice.service.impl;

import com.bookstore.bookmanagementservice.payload.dto.GenreDto;
import com.bookstore.bookmanagementservice.payload.responses.GenreListResponse;
import com.bookstore.bookmanagementservice.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Override
    public GenreDto createNewGenre(GenreDto genre) {
        return null;
    }

    @Override
    public List<GenreListResponse> getAllGenres() {
        return List.of();
    }

    @Override
    public GenreDto getGenreById(Integer id) {
        return null;
    }

    @Override
    public void deleteGenreById(Integer id) {

    }

    @Override
    public GenreDto updateGenreById(Integer id, GenreDto genre) {
        return null;
    }
}
