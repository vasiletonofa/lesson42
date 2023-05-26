package com.tekwill.lesson42.truckCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DriversServiceImpl implements DriversService {

    @Autowired
    private DriversRepository driversRepository;

    @Override
    public void createTable() {
        try {
            driversRepository.createTable();
        }  catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void addDriver(Driver driver) {
        System.out.println("Cream soferul: " + driver);

        if(driver.experience == 0) {
            throw new RuntimeException("Nu se accepto soferi fara experienta !");
        }

        try {
            driversRepository.createDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Driver> getAllDrivers() {

        List<Driver> drivers = new ArrayList<>();
        try {
            drivers = driversRepository.loadAllDrivers();
        } catch (SQLException e) {
          e.printStackTrace();
        }

        return drivers;
    }

    @Override
    public Driver getDriverById(long id) {

        Driver driver = null;
        try {
            driver = driversRepository.findDriverById(id);
            System.out.println(driver);
        } catch (SQLException e) {
          e.printStackTrace();
        }

        return driver;
    }

    @Override
    public List<Driver> getDriverByName(String name) {
        List<Driver> drivers = new ArrayList<>();
        try {
            drivers = driversRepository.findDriverByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drivers;
    }

    @Override
    public void deleteDriverById(Long id) {
        try {
            driversRepository.deleteDriverById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDriver(Driver driver) {
        try {
            driversRepository.updateDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
