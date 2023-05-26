package com.tekwill.lesson42.truckCompany;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DriversRepositoryImpl implements DriversRepository {

    Connection conn;

    public DriversRepositoryImpl() {
        try {
            String url = "jdbc:h2:mem:";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @PreDestroy
    void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() throws SQLException {
            String createTable = "CREATE TABLE driver(\n" +
                    "   id BIGINT AUTO_INCREMENT,\n" +
                    "   first_name VARCHAR(40),\n" +
                    "   last_name VARCHAR(40),\n" +
                    "   experience INT,\n" +
                    "   PRIMARY KEY(id)\n" +
                    "); ";

            PreparedStatement stmt = conn.prepareStatement(createTable);

            stmt.execute();
            stmt.close();
    }

    @Override
    public void createDriver(Driver driver) throws SQLException {

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO driver(first_name, last_name, experience) VALUES(?, ?, ?);");

            stmt.setString(1, driver.getFirstName());
            stmt.setString(2, driver.getLastName());
            stmt.setInt(3, driver.getExperience());

            stmt.executeUpdate();
            stmt.close();
    }

    @Override
    public List<Driver> loadAllDrivers() throws SQLException {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM driver");

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Driver> driverList = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Integer experience = resultSet.getInt(4);

                Driver driver = new Driver(id, firstName, lastName, experience);

                driverList.add(driver);
            }

            preparedStatement.close();

            return driverList;

    }

    @Override
    public Driver findDriverById(long driverId) throws SQLException {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM driver WHERE id = ?");

            preparedStatement.setLong(1, driverId);

            ResultSet resultSet = preparedStatement.executeQuery();

            Driver driver = null;

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Integer experience = resultSet.getInt(4);

                driver = new Driver(id, firstName, lastName, experience);
            }

            preparedStatement.close();

            return driver;
    }

    @Override
    public List<Driver> findDriverByName(String name) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM driver WHERE first_name = ?");

        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Driver> drivers = new ArrayList<>();

        while (resultSet.next()) {
            Long id = resultSet.getLong(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            Integer experience = resultSet.getInt(4);

            Driver driver = new Driver(id, firstName, lastName, experience);

            drivers.add(driver);
        }

        preparedStatement.close();

        return drivers;
    }

    @Override
    public void deleteDriverById(Long id) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM driver WHERE id = ?");

        preparedStatement.setLong(1, id);

        preparedStatement.execute();

        preparedStatement.close();
    }

    @Override
    public void updateDriver(Driver driver) throws SQLException {
        PreparedStatement preparedStatement =
                conn.prepareStatement("UPDATE driver SET first_name = ?, last_name = ?, experience = ? WHERE id = ?");

        preparedStatement.setString(1, driver.getFirstName());
        preparedStatement.setString(2, driver.getLastName());
        preparedStatement.setInt(3, driver.getExperience());
        preparedStatement.setLong(4, driver.getId());

        preparedStatement.execute();

        preparedStatement.close();
    }

}
