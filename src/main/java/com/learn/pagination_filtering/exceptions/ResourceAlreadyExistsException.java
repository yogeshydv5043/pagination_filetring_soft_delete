package com.learn.pagination_filtering.exceptions;

public class ResourceAlreadyExistsException extends  RuntimeException {

    public ResourceAlreadyExistsException() {
    }

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
