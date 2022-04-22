package com.example.emt_lab2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AuthorNotFound extends RuntimeException {
    public AuthorNotFound(Long id) {
        super(String.format("Author with ID %d, not found.", id));
    }
}
