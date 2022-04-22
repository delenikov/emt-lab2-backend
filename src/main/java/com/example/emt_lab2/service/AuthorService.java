package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> findByName(String name);
}
