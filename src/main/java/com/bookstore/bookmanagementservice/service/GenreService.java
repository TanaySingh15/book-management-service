package com.bookstore.bookmanagementservice.service;

import com.bookstore.bookmanagementservice.payload.dto.GenreDto;
import com.bookstore.bookmanagementservice.payload.responses.GenreListResponse;

import java.util.List;

public interface GenreService {

    GenreDto createNewGenre(GenreDto genre);
    List<GenreListResponse> getAllGenres();
    GenreDto getGenreById(Integer id);
    void deleteGenreById(Integer id);
    GenreDto updateGenreById(Integer id, GenreDto genre);
}
