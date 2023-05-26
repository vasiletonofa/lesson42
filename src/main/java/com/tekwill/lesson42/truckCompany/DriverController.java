package com.tekwill.lesson42.truckCompany;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DriverController {
    // FE -> HTTP ->  BE

    // POST -> create
    // GET -> cerem date
    // DELETE - Sterge rinduri din tabela
    // PUT - Updateaze rindul din tabela

    // REST -> JSON
    // SOAP -> XML

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

    @GetMapping("/driver/id/{id}")
    Driver getAllDriversById(@PathVariable Long id) {
        return driversService.getDriverById(id);
    }

    @GetMapping("/driver/name/{name}")
    List<Driver> getAllDriversByName(@PathVariable String name) {
        return driversService.getDriverByName(name);
    }

    @DeleteMapping("/driver/id/{id}")
    void deleteDriverById(@PathVariable Long id) {
        driversService.deleteDriverById(id);
    }

    @PutMapping("/driver/update")
    void updateDriver(@RequestBody Driver driver) {
        driversService.updateDriver(driver);
    }

}
