package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> findByName(String name);

    Optional<Book> save(String name, String category, Long author, Integer availableCopies);
    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, String category, Long author, Integer availableCopies);
    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);
    Optional<Book> markAsTakenById(Long id);
}
