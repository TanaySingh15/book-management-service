package com.bookstore.bookmanagementservice.repository;

import com.bookstore.bookmanagementservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
