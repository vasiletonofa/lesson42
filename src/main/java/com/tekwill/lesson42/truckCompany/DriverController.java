package com.tekwill.lesson42.truckCompany;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class DriverController {
    // FE -> HTTP ->  BE

    // POST -> create
    // GET -> cerem date

    // REST -> JSON

    @Autowired
    DriversService driversService;

    @PostMapping("/driver/add")
    public void createDriver(@RequestBody Driver driver) {
        driversService.addDriver(driver);
    }

    @GetMapping("/driver/all")
    List<Driver> getAllDrivers() {
        return driversService.getAllDrivers();
    }

}
