package com.bookstore.bookmanagementservice.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreException extends Exception{
    String resourceName;
    public GenreException(String resourceName) {
        this.resourceName = resourceName;
    }
}
