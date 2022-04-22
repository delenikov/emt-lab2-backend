package com.example.emt_lab2.controllers;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://library-frontend-191232.herokuapp.com")
@RequestMapping(value = {"/authors"})

public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    private List<Author> findAll() {
        return this.authorService.findAll();
    }

}
