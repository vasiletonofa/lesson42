package com.tekwill.lesson42;

import com.tekwill.lesson42.truckCompany.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson42Application implements CommandLineRunner {

    @Autowired
    DriversService driversService;

    public static void main(String[] args) {
        SpringApplication.run(Lesson42Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        driversService.createTable();
    }
}
