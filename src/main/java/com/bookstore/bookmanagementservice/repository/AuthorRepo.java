package com.bookstore.bookmanagementservice.repository;

import com.bookstore.bookmanagementservice.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
    Author findByName(String name);
}
