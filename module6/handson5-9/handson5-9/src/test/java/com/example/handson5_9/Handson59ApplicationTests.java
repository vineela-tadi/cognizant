package com.example.handson5_9;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.handson5_9.entity.Country;
import com.example.handson5_9.service.CountryService;

@SpringBootTest
class Handson59ApplicationTests {

    @Autowired
    private CountryService countryService;

    @Test
    void testFindCountryByCode() {
        Country country = countryService.findCountryByCode("IN");
        System.out.println(country);
    }
    @Test
void testAddCountry() {

    Country country = new Country("AU", "Australia");

    countryService.addCountry(country);

    Country result = countryService.findCountryByCode("AU");

    System.out.println(result);
}
@Test
void testUpdateCountry() {

    countryService.updateCountry("AU", "New Australia");

    Country country = countryService.findCountryByCode("AU");

    System.out.println(country);
}
@Test
void testDeleteCountry() {

    countryService.deleteCountry("AU");

    System.out.println("Country Deleted Successfully");
}ś
}