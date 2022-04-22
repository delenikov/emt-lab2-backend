package com.example.emt_lab2.service.impl;

import com.example.emt_lab2.Exceptions.AuthorNotFound;
import com.example.emt_lab2.Exceptions.BookNotFound;
import com.example.emt_lab2.enums.Category;
import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.dto.BookDto;
import com.example.emt_lab2.repository.AuthorRepository;
import com.example.emt_lab2.repository.BookRepository;
import com.example.emt_lab2.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, String categoryName, Long authorId, Integer availableCopies) {
       Category category = Category.valueOf(categoryName);
       Author author = this.authorRepository.findById(authorId).orElseThrow(()-> new AuthorNotFound(authorId));
       Book book = new Book(name, category, author, availableCopies);
       this.bookRepository.save(book);
       return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Category category = Category.valueOf(bookDto.getCategory());
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFound(bookDto.getAuthor()));
        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), category, author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, String categoryId, Long authorId, Integer availableCopies) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFound(id));
        Category category = Category.valueOf(bookDto.getCategory());
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFound(bookDto.getAuthor()));
        book.setName(bookDto.getName());
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        if(this.bookRepository.findById(id).isPresent()){
            this.bookRepository.deleteById(id);
        }
    }

    @Override
    public Optional<Book> markAsTakenById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFound(id));
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }


}
