package com.bookstore.bookmanagementservice.controllers;

import com.bookstore.bookmanagementservice.exception.GenreException;
import com.bookstore.bookmanagementservice.payload.dto.GenreDto;
import com.bookstore.bookmanagementservice.payload.responses.ApiResponse;
import com.bookstore.bookmanagementservice.payload.responses.GenreResponse;
import com.bookstore.bookmanagementservice.service.impl.GenreServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/genre/")
public class GenreController {

    @Resource
    private GenreServiceImpl genreService;

    @PostMapping
    public ResponseEntity<GenreResponse> addGenre(@RequestBody GenreDto genreDto) {
        GenreDto newGenre = genreService.createNewGenre(genreDto);
        Set<String> books = new HashSet<>();
        newGenre.getBook().forEach(book -> books.add(book.getTitle()));
        GenreResponse genreResponse = new GenreResponse(newGenre.getName(), books);
        return new ResponseEntity<>(genreResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<GenreResponse> updateGenre(@RequestBody GenreDto genreDto, @PathVariable Integer id) {
        GenreDto updateGenre = genreService.updateGenreById(id, genreDto);
        Set<String> books = new HashSet<>();
        updateGenre.getBook().forEach(book -> books.add(book.getTitle()));
        GenreResponse genreResponse = new GenreResponse(updateGenre.getName(), books);
        return new ResponseEntity<>(genreResponse, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteGenre(@RequestBody GenreDto genreDto, @PathVariable Integer id) throws GenreException {
        genreService.deleteGenreById(id);
        ApiResponse apiResponse = new ApiResponse("Successfully Deleted", HttpStatus.OK);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GenreResponse> getGenreById(@PathVariable Integer id) {
        GenreDto getGenre = genreService.getGenreById(id);
        Set<String> books = new HashSet<>();
        getGenre.getBook().forEach(book -> books.add(book.getTitle()));
        GenreResponse genreResponse = new GenreResponse(getGenre.getName(), books);
        return new ResponseEntity<>(genreResponse, HttpStatus.FOUND);
    }
}
