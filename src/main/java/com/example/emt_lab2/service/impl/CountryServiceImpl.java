package com.example.emt_lab2.service.impl;

import com.example.emt_lab2.model.Country;
import com.example.emt_lab2.repository.CountryRepository;
import com.example.emt_lab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> findByName(String name) {
        return this.countryRepository.findByName(name);
    }
}
