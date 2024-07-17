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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer authorId;

    @Column
    String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    Set<Book> books;
}
