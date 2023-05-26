package com.tekwill.lesson42.truckCompany;

import java.sql.SQLException;
import java.util.*;
public interface DriversRepository {


    void createTable() throws SQLException;

    void createDriver(Driver driver) throws SQLException;

    List<Driver> loadAllDrivers() throws SQLException;

    Driver findDriverById(long id) throws SQLException;

    List<Driver> findDriverByName(String name) throws SQLException;

    void deleteDriverById(Long id) throws SQLException;

    void updateDriver(Driver driver) throws SQLException;
}
