package com.bookstore.bookmanagementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer genreId;

    @Column
    String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.PERSIST)
    Set<Book> book;
}
