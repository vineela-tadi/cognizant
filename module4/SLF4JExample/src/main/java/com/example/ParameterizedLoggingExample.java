package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    // Create Logger
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String name = "Vineela";
        int age = 22;
        double salary = 50000.75;

        // Parameterized logging (Single values)
        logger.info("User name is {}", name);
        logger.info("User age is {}", age);
        logger.info("User salary is {}", salary);

        // Multiple parameters
        logger.info("User {} is {} years old and earns {}", name, age, salary);

        // Warning level
        logger.warn("Low balance for user {} with salary {}", name, salary);

        // Error level
        logger.error("Error occurred for user {}", name);
    }
}