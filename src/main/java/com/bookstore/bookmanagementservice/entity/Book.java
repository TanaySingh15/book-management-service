package com.bookstore.bookmanagementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    Author author;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Genre genre;
}
