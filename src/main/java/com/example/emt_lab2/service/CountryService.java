package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> findByName(String name);
}
