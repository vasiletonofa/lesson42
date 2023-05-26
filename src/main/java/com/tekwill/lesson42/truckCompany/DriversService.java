package com.tekwill.lesson42.truckCompany;

import java.util.*;
public interface DriversService {


    void createTable();

    void addDriver(Driver driver);

    List<Driver> getAllDrivers();

    Driver getDriverById(long id);

    List<Driver> getDriverByName(String name);


    void deleteDriverById(Long id);

    void updateDriver(Driver driver);
}
