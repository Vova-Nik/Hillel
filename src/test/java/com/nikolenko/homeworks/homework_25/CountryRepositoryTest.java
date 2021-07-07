package com.nikolenko.homeworks.homework_25;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CountryRepositoryTest {

    private static Connection connection;
    private static Statement statement;

    @BeforeAll
    static void setup() {
    }

    @AfterAll
    static void close() {
        ConnectionFactory.close();
    }

    @Test
    void getById() {
        CountryRepository countryRepository = new CountryRepository();
        Country country = countryRepository.getById("UKR");
        assertTrue(country.getName().length() > 2);
        log.info(country.toString());
        country = countryRepository.getById("ZWE");
        assertTrue(country.getPopulation() > 20);
        log.info(country.toString());
        ConnectionFactory.close();
    }

    @Test
    void getAll() {
        CountryRepository countryRepository = new CountryRepository();
        List<Country> requestResult = countryRepository.getAll();
        assertFalse(requestResult.isEmpty());
        assertTrue(requestResult.size() > 8);
        log.info(requestResult.get(0).toString());
        log.info("There are " + requestResult.size() + " records found");
        ConnectionFactory.close();
    }

    @Test
    void count() {
        CountryRepository countryRepository = new CountryRepository();
        long result = countryRepository.count();
        log.info("There are " + result + " countries in DB found");
        assertTrue(result > 10);
        ConnectionFactory.close();

    }

    @Test
    void insert() {
        this.deleteLapland();
        long recordAmmountBefore = this.countRecords();
        CountryRepository countryRepository = new CountryRepository();
        Country country = this.createLapland();
        Country countryBack = countryRepository.insert(country);
        assertEquals(recordAmmountBefore, this.countRecords() - 1);
        log.info(countryBack.toString());
        this.deleteLapland();
        assertEquals(recordAmmountBefore, this.countRecords());
        ConnectionFactory.close();
    }
   
    @Test
    void delete() {
        CountryRepository countryRepository = new CountryRepository();
        this.deleteLapland();

        long recordAmmountBefore = this.countRecords();
        this.insertLapland();
        assertEquals(recordAmmountBefore, this.countRecords() - 1);
        assertTrue(this.existsLapland());

        countryRepository.delete("XYZ");
        assertEquals(recordAmmountBefore,this.countRecords());
        assertFalse(this.existsLapland());
        ConnectionFactory.close();
    }

    @Test
    void exists() {
        CountryRepository countryRepository = new CountryRepository();
        boolean result = countryRepository.exists("UKR");
        assertTrue(result);
        result = countryRepository.exists("1VV");
        assertFalse(result);
        ConnectionFactory.close();
    }

    @Test
    void testGetByLongId() {
        try {
            CountryRepository countryRepository = new CountryRepository();
            countryRepository.getById(10L);
        } catch (IllegalArgumentException e) {
            assertTrue(e.toString().contains("in class Country"));
            return;
        }
        fail();
    }

    @Test
    void testDeleteByLongId() {
        try {
            CountryRepository countryRepository = new CountryRepository();
            countryRepository.delete(10L);
        } catch (IllegalArgumentException e) {
            assertTrue(e.toString().contains("in class Country"));
            return;
        }
        fail();
    }

    @Test
    void testExistsByLongId() {
        try {
            CountryRepository countryRepository = new CountryRepository();
            countryRepository.exists(10L);
        } catch (IllegalArgumentException e) {
            assertTrue(e.toString().contains("in class Country"));
            return;
        }
        fail();
    }

    @Test
    void serviceMethodsTest() {
        long recordsQuantaty = 0;
        deleteLapland();
        recordsQuantaty = countRecords();
        insertLapland();
        assertEquals(recordsQuantaty, countRecords() - 1);
        deleteLapland();
        assertEquals(recordsQuantaty, countRecords());
    }

    void insertLapland() {
        if (existsLapland()) {
            return;
        }
        String insQuery = "INSERT INTO country " +
                "(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2) " +
                "VALUES ('XYZ', 'Laplandia', 'Africa', 'Eastern Africa', 1, 1, 128, 99, 10000, 11000, 'Laplandia', 'Republic', 'Santa Claus', 100, 'LP')";

        try (Connection connection = DriverManager.getConnection(ConnectionFactory.getHost(), ConnectionFactory.getUsername(), ConnectionFactory.getPassword())) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(insQuery);
            } catch (SQLException e) {
                log.error("Bad SQL. insertLapland() error... " + e.toString());
            }
        } catch (java.sql.SQLException e) {
            log.error("insertLapland() error..." + e.toString());
        }
    }

    void deleteLapland() {
        if (!existsLapland()) {
            return;
        }
        String delQuery = "DELETE FROM country WHERE Code ='XYZ'";
        try (Connection connection = DriverManager.getConnection(ConnectionFactory.getHost(), ConnectionFactory.getUsername(), ConnectionFactory.getPassword())) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(delQuery);
            } catch (SQLException e) {
                log.error("Bad SQL. deleteLapland() " + e.toString());
            }
        } catch (java.sql.SQLException e) {
            log.error("deleteLapland() error..." + e.toString());
        }
    }

    public Long countRecords() {
        String query = "SELECT COUNT(*) FROM country WHERE 1";
        ResultSet resultSet = null;
        long result = 0;
        try (Connection connection = DriverManager.getConnection(ConnectionFactory.getHost(), ConnectionFactory.getUsername(), ConnectionFactory.getPassword())) {
            try (Statement stmt = connection.createStatement()) {
                resultSet = stmt.executeQuery(query);
                resultSet.next();
                result = resultSet.getInt("count(*)");
            } catch (SQLException e) {
                log.error("Bad SQL. countRecords() " + e.toString());
            }
        } catch (java.sql.SQLException e) {
            log.error("Connection failed...countRecords() " + e.toString());
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (java.sql.SQLException e) {
                log.error("Result set closing failed...countRecords() " + e.toString());
            }
        }
        return result;
    }

    public boolean existsLapland() {
        //String query = "SELECT 1 FROM country WHERE `Code`='XYZ' LIMIT 1";
        String query = "SELECT COUNT(1) FROM country WHERE Code = 'XYZ'";
        ResultSet resultSet = null;
        boolean result = false;
        try (Connection connection = DriverManager.getConnection(ConnectionFactory.getHost(), ConnectionFactory.getUsername(), ConnectionFactory.getPassword())) {
            try (Statement stmt = connection.createStatement()) {
                resultSet = stmt.executeQuery(query);
                resultSet.next();
                result = resultSet.getBoolean("COUNT(1)");
            } catch (SQLException e) {
                log.error("Bad SQL. existsLapland() " + e.toString());
            }
        } catch (java.sql.SQLException e) {
            log.error("Connection failed... existsLapland() " + e.toString());
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (java.sql.SQLException e) {
                log.error("Result set closing failed...existsLapland " + e.toString());
            }
        }
        return result;
    }

    Country createLapland() {
        return Country.builder()
                .code("XYZ")
                .name("Laplandia")
                .continent("Africa")
                .region("Eastern Africa")
                .surfaceArea(1)
                .indepYear(1)
                .population(128)
                .lifeExpectancy(99)
                .gnp(10000)
                .gnpOld(11000)
                .localName("Laplandia")
                .governmentForm("Republic")
                .headOfState("Santa Claus")
                .capital(2)
                .code2("LP")
                .build();
    }

}