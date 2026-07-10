 package com.cognizant.spring_learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
@Service
public class CountryService {

    public List<Country> getAllCountries() {

        List<Country> countries = new ArrayList<>();

        Country c1 = new Country();
        c1.setCode("IN");
        c1.setName("India");
        countries.add(c1);

        Country c2 = new Country();
        c2.setCode("US");
        c2.setName("United States");
        countries.add(c2);

        Country c3 = new Country();
        c3.setCode("JP");
        c3.setName("Japan");
        countries.add(c3);

        Country c4 = new Country();
        c4.setCode("DE");
        c4.setName("Germany");
        countries.add(c4);

        return countries;
    }

    public Country getCountry(String code) {

        List<Country> countries = getAllCountries();

        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        throw new CountryNotFoundException();
    }
}            