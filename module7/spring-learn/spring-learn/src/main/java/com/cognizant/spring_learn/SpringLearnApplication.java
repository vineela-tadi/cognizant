package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnApplication.class, args);

        displayDate();
        //displayCountry();
        displayCountries();
    }

    public static void displayDate() {

        LOGGER.info("START");

        try {

            ApplicationContext context =
                    new ClassPathXmlApplicationContext("date-format.xml");

            SimpleDateFormat format =
                    context.getBean("dateFormat", SimpleDateFormat.class);

            Date date = format.parse("31/12/2018");

            LOGGER.debug("Date : {}", date);

        } catch (Exception e) {
            LOGGER.error("Error", e);
        }

        LOGGER.info("END");
    }
    public static void displayCountry() {

    LOGGER.info("START");

    ApplicationContext context =
        new ClassPathXmlApplicationContext("country.xml");

Country country =
        context.getBean("in", Country.class);


LOGGER.info("END");
}
public static void displayCountries() {

    LOGGER.info("START");

    ApplicationContext context =
            new ClassPathXmlApplicationContext("country.xml");

    List<Country> countryList =
            context.getBean("countryList", List.class);

    LOGGER.debug("Countries : {}", countryList);

    LOGGER.info("END");
}
}