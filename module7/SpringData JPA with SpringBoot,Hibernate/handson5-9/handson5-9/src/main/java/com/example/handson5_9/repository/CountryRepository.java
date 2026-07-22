package com.example.handson5_9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.handson5_9.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}