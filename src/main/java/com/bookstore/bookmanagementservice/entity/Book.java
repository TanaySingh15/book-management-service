package com.bookstore.bookmanagementservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer bookId;

    @Column
    String title;

    @Column
    String isbn;

    @Column
    Integer stock;

    @Column
    long created_date;

    @Column
    long updated_date;

    @ManyToOne
    Author author;

    @ManyToOne
    Genre genre;
}
