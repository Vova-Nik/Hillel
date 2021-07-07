package com.nikolenko.homeworks.homework_25;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CityRepositoryTest {

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
        CityRepository cityRepository = new CityRepository();
        City city = cityRepository.getById(2L);
        assertTrue(city.getName().length() > 2);
        log.info(city.toString());
        assertTrue(city.getPopulation() > 20);
        ConnectionFactory.close();
    }

    @Test
    void getAll() {
        CityRepository cityRepository = new CityRepository();
        List<City> requestResult = cityRepository.getAll();
        assertFalse(requestResult.isEmpty());
        assertTrue(requestResult.size() > 8);
        log.info(requestResult.get(0).toString());
        log.info("There are " + requestResult.size() + " records found");
        ConnectionFactory.close();
    }

    @Test
    void count() {
        CityRepository cityRepository = new CityRepository();
        long result = cityRepository.count();
        log.info("There are " + result + " cities in DB found");
        assertTrue(result > 10);
        ConnectionFactory.close();

    }

    @Test
    void insert() {
        this.deleteKarfagen();
        long recordAmmountBefore = this.countRecords();
        CityRepository cityRepository = new CityRepository();
        City city = this.createKarfagen();
        City CityBack = cityRepository.insert(city);
        assertEquals(recordAmmountBefore, this.countRecords() - 1);
        log.info(CityBack.toString());
        this.deleteKarfagen();
        assertEquals(recordAmmountBefore, this.countRecords());
        ConnectionFactory.close();
    }

    @Test
    void delete() {
        CityRepository cityRepository = new CityRepository();
        this.deleteKarfagen();

        long recordAmmountBefore = this.countRecords();
        long newKarfagenId = this.insertKarfagen();
        assertEquals(recordAmmountBefore, this.countRecords() - 1);
        assertTrue(this.existsKarfagen());

        cityRepository.delete(newKarfagenId);
        assertEquals(recordAmmountBefore, this.countRecords());
        assertFalse(this.existsKarfagen());
        ConnectionFactory.close();
    }

    @Test
    void exists() {
        CityRepository cityRepository = new CityRepository();
        boolean result = cityRepository.exists(101L);
        assertTrue(result);
        result = cityRepository.exists(100_000L);
        assertFalse(result);
        ConnectionFactory.close();
    }

    @Test
    void testGetByString() {
        try {
            CityRepository cityRepository = new CityRepository();
            cityRepository.getById("GHdsauihy9");
        } catch (IllegalArgumentException e) {
            assertTrue(e.toString().contains("in class City"));
            return;
        }
        fail();
    }

    @Test
    void testDeleteByString() {
        try {
            CityRepository cityRepository = new CityRepository();
            cityRepository.delete("10L");
        } catch (IllegalArgumentException e) {
            assertTrue(e.toString().contains("in class City"));
            return;
        }
        fail();
    }

    @Test
    void testExistsByString() {
        try {
            CityRepository cityRepository = new CityRepository();
            cityRepository.exists("25");
        } catch (IllegalArgumentException e) {
            assertTrue(e.toString().contains("in class City"));
            return;
        }
        fail();
    }


    @Test
    void serviceMethodsTest() {
        long recordsQuantaty = 0;
        deleteKarfagen();
        recordsQuantaty = countRecords();
        int karfagenId = insertKarfagen();
        assertTrue(karfagenId > 0);
        assertEquals(recordsQuantaty, countRecords() - 1);
        deleteKarfagen();
        assertEquals(recordsQuantaty, countRecords());
    }

    private City createKarfagen() {
        return City.builder()
                .id(0)
                .name("Karfagen")
                .countryCode("TUN")
                .district("Karfagen")
                .population(1)
                .build();
    }

    private int insertKarfagen() {
        int karfagenId = getKarfagenId();
        if (karfagenId > -1) {
            return karfagenId;
        }
        String insQuery = "INSERT INTO City " +
                "(Name, CountryCode, District, Population) " +
                "VALUES ('Karfagen', 'TUN', 'Karfagen', 1)";

        try (Connection connection = DriverManager.getConnection(ConnectionFactory.getHost(), ConnectionFactory.getUsername(), ConnectionFactory.getPassword())) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(insQuery);
            } catch (SQLException e) {
                log.error("Bad SQL. insertKarfagen() error... " + e.toString());
            }
        } catch (java.sql.SQLException e) {
            log.error("insertKarfagen() error..." + e.toString());
        }
        return getKarfagenId();
    }

    private int getKarfagenId() {
        int result = -1;
        if (!existsKarfagen()) {
            return result;
        }
        try (Connection connection = DriverManager.getConnection(ConnectionFactory.getHost(), ConnectionFactory.getUsername(), ConnectionFactory.getPassword())) {
            try (Statement stmt = connection.createStatement()) {
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM City WHERE Name = 'Karfagen'");
                resultSet.next();
                result = resultSet.getInt("ID");
            } catch (SQLException e) {
                log.error("Bad SQL. countRecords() " + e.toString());
            }
        } catch (java.sql.SQLException e) {
            log.error("insertLapland() error..." + e.toString());
        }
        return result;
    }

    private void deleteKarfagen() {
        while(existsKarfagen()) {
            String delQuery = "DELETE FROM City WHERE Name ='Karfagen'";
            try (Connection connection = DriverManager.getConnection(ConnectionFactory.getHost(), ConnectionFactory.getUsername(), ConnectionFactory.getPassword())) {
                try (Statement stmt = connection.createStatement()) {
                    stmt.executeUpdate(delQuery);
                } catch (SQLException e) {
                    log.error("Bad SQL. deleteKarfagen() " + e.toString());
                }
            } catch (java.sql.SQLException e) {
                log.error("deleteKarfagen() error..." + e.toString());
            }
        }
    }

    private Long countRecords() {
        String query = "SELECT COUNT(*) FROM City WHERE 1";
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

    private boolean existsKarfagen() {
        //String query = "SELECT 1 FROM City WHERE `Code`='XYZ' LIMIT 1";
        String query = "SELECT COUNT(1) FROM City WHERE Name ='Karfagen'";
        ResultSet resultSet = null;
        boolean result = false;
        int resulti = -1;
        try (Connection connection = DriverManager.getConnection(ConnectionFactory.getHost(), ConnectionFactory.getUsername(), ConnectionFactory.getPassword())) {
            try (Statement stmt = connection.createStatement()) {
                resultSet = stmt.executeQuery(query);
                resultSet.next();
                resulti = resultSet.getInt("COUNT(1)");
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
        return resulti>0;
    }

}