package com.example.handson5_9.exception;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(String message) {
        super(message);
    }

}