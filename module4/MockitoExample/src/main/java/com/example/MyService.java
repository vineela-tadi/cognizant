package com.example;

public class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    // used in ALL tests
    public String fetchData(String input) {
        return api.getData(input);
    }

}