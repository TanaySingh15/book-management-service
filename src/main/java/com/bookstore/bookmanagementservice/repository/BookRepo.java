package com.bookstore.bookmanagementservice.repository;

import com.bookstore.bookmanagementservice.entity.Book;
import com.bookstore.bookmanagementservice.payload.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findByTitle(String title);
}
