package com.bookstore.bookmanagementservice.repository;

import com.bookstore.bookmanagementservice.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre,Integer> {
    Genre findByName(String name);
}
