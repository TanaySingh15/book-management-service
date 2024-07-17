package com.bookstore.bookmanagementservice.service.impl;

import com.bookstore.bookmanagementservice.entity.Genre;
import com.bookstore.bookmanagementservice.exception.GenreException;
import com.bookstore.bookmanagementservice.exception.ResourceNotFoundException;
import com.bookstore.bookmanagementservice.payload.dto.GenreDto;
import com.bookstore.bookmanagementservice.repository.GenreRepo;
import com.bookstore.bookmanagementservice.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepo genreRepo;

    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public GenreDto createNewGenre(GenreDto genreDto) {
        Genre genre = modelMapper.map(genreDto, Genre.class);
        genre = genreRepo.save(genre);
        return modelMapper.map(genre, GenreDto.class);
    }

    @Override
    public GenreDto getGenreById(Integer id) {
        Genre genre = genreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre"));
        return modelMapper.map(genre, GenreDto.class);
    }

    @Override
    public void deleteGenreById(Integer id) throws GenreException {
        Genre genre = genreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre"));
        if(Objects.isNull(genre.getBook()) || genre.getBook().isEmpty()) {
            genreRepo.deleteById(id);
        } else {
            throw new GenreException("Unable to delete genre");
        }
    }

    @Override
    public GenreDto updateGenreById(Integer id, GenreDto genreDto) {
        Genre genre = genreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre"));
        Genre updatedGenre = modelMapper.map(genreDto, Genre.class);
        genre.setGenreId(id);
        genre.setName(updatedGenre.getName());
        genre.setBook(updatedGenre.getBook());
        genre = genreRepo.save(genre);
        return modelMapper.map(genre, GenreDto.class);
    }
}
