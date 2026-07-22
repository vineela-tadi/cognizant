package com.example.handson5_9.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.handson5_9.entity.Country;
import com.example.handson5_9.exception.CountryNotFoundException;
import com.example.handson5_9.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country Not Found");
        }

        Country country = result.get();

        return country;
    }
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    @Transactional
public void updateCountry(String code, String name) {

    Country country = countryRepository.findById(code)
            .orElseThrow(() -> new CountryNotFoundException("Country Not Found"));

    country.setName(name);

    countryRepository.save(country);
}
@Transactional
public void deleteCountry(String code) {
    countryRepository.deleteById(code);
}
}