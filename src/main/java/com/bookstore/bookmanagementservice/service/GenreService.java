package com.bookstore.bookmanagementservice.service;

import com.bookstore.bookmanagementservice.exception.GenreException;
import com.bookstore.bookmanagementservice.payload.dto.GenreDto;
import com.bookstore.bookmanagementservice.payload.responses.GenreListResponse;

import java.util.List;

public interface GenreService {

    GenreDto createNewGenre(GenreDto genre);
    GenreDto getGenreById(Integer id);
    void deleteGenreById(Integer id) throws GenreException;
    GenreDto updateGenreById(Integer id, GenreDto genre);
}
