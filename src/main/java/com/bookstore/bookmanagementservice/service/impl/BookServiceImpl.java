package com.bookstore.bookmanagementservice.service.impl;

import com.bookstore.bookmanagementservice.entity.Author;
import com.bookstore.bookmanagementservice.entity.Book;
import com.bookstore.bookmanagementservice.entity.Genre;
import com.bookstore.bookmanagementservice.exception.AuthorException;
import com.bookstore.bookmanagementservice.exception.GenreException;
import com.bookstore.bookmanagementservice.exception.ResourceNotFoundException;
import com.bookstore.bookmanagementservice.payload.dto.BookDto;
import com.bookstore.bookmanagementservice.repository.AuthorRepo;
import com.bookstore.bookmanagementservice.repository.BookRepo;
import com.bookstore.bookmanagementservice.repository.GenreRepo;
import com.bookstore.bookmanagementservice.service.BookService;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    GenreRepo genreRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public BookDto createNewBook(BookDto bookDto) throws AuthorException, GenreException {
        Book book = modelMapper.map(bookDto, Book.class);
        if(Objects.isNull(bookDto.getAuthor().getName())){
            throw new AuthorException("Author cannot be empty");
        }

        if(Objects.isNull(bookDto.getGenre().getName())){
            throw new GenreException("Genre cannot be empty");
        }
        Author author = authorRepo.findByName(bookDto.getAuthor().getName());
        Genre genre = genreRepo.findByName(bookDto.getGenre().getName());
        Set<Book> books = new HashSet<>();
        books.add(book);
        if(author == null){
            author.setName(bookDto.getAuthor().getName());
            author.setBooks(books);
            author = authorRepo.save(author);
        }
        if(genre == null){
            genre.setName(bookDto.getGenre().getName());
            genre.setBook(books);
            genre = genreRepo.save(genre);
        }

        book.setAuthor(author);
        book.setGenre(genre);
        book.setUpdated_date(Instant.now().toEpochMilli());
        book.setCreated_date(Instant.now().toEpochMilli());
        Book savedBook = bookRepo.save(book);
        return modelMapper.map(savedBook, BookDto.class);
    }

    @Override
    public BookDto getBookById(Integer id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book"));
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public void deleteBookById(Integer id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book"));
        bookRepo.delete(book);
    }

    @Override
    public BookDto updateBookById(Integer id, BookDto bookDto) {
        Book book1 = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book"));
        Book book2 = modelMapper.map(bookDto, Book.class);
        book1.setTitle(book2.getTitle());
        book1.setGenre(book2.getGenre());
        book1.setAuthor(book2.getAuthor());
        book1.setIsbn(book2.getIsbn());
        book1.setStock(book2.getStock());
        book1.setUpdated_date(Instant.now().toEpochMilli());
        bookRepo.save(book1);
        return null;
    }
}
