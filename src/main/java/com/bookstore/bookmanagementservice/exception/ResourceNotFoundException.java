package com.bookstore.bookmanagementservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

    String resourceName;

    public ResourceNotFoundException(String resourceName) {
        super("Not found");
        this.resourceName = resourceName;
    }
}
