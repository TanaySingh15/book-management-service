package com.bookstore.bookmanagementservice.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorException extends Exception{
    String resourceName;
    public AuthorException(String resourceName) {
        this.resourceName = resourceName;
    }
}
