package com.bookstore.bookmanagementservice.service.impl;

import com.bookstore.bookmanagementservice.entity.Author;
import com.bookstore.bookmanagementservice.exception.AuthorException;
import com.bookstore.bookmanagementservice.exception.ResourceNotFoundException;
import com.bookstore.bookmanagementservice.payload.dto.AuthorDto;
import com.bookstore.bookmanagementservice.repository.AuthorRepo;
import com.bookstore.bookmanagementservice.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthorDto createNewAuthor(AuthorDto authorDto) {
        Author author = modelMapper.map(authorDto, Author.class);
        author = authorRepo.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }

    @Override
    public AuthorDto getAuthorById(Integer id) {
        Author author = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author"));
        return modelMapper.map(author, AuthorDto.class);
    }

    @Override
    public void deleteAuthorById(Integer id) throws AuthorException {
        Author author = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author"));
        if(Objects.isNull(author.getBooks()) || author.getBooks().isEmpty()) {
            authorRepo.deleteById(id);
        } else {
            throw new AuthorException("Unable to delete author");
        }
    }

    @Override
    public AuthorDto updateAuthorById(Integer id, AuthorDto authorDto) {
        Author author = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author"));
        Author updatedAuthor = modelMapper.map(authorDto, Author.class);
        author.setAuthorId(id);
        author.setName(updatedAuthor.getName());
        author.setBooks(updatedAuthor.getBooks());
        author = authorRepo.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }
}
