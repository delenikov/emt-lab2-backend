package com.example.emt_lab2.model.dto;

import com.example.emt_lab2.enums.Category;
import com.example.emt_lab2.model.Author;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class BookDto {
    private String name;
    private String category;
    private Long author;
    private Integer availableCopies;

    public BookDto(String name, String category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
