package com.nikolenko.homeworks.homework_24;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DBDataGetterTest {
    static String dataBaseName;
    static String username;
    static String password;
    static String host;

    private ResultSet resultSet = null;

    @BeforeAll
    static void setup() {
        dataBaseName = "hillel";
        username = "root";
        password = "root";
        host = "jdbc:mysql://localhost/";
    }

    @Test
    void testDBConnection() {
        try (Connection connection = DriverManager.getConnection(host + dataBaseName, username, password)) {
            log.info("Connection to hillel DB succesfull!");
        } catch (Exception ex) {
            log.error("Connection failed...");
            fail();
        }
    }

    @Test
    void testSimpleQuery() {
        String query;
        String result;

        query = "SELECT * FROM EMPLOYEES em";
        result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("1") && result.contains("2"));
    }

    @Test
    void punkt1() {
        /* 1. Выбрать всех работников с нечетными Id*/
        String query = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID%2=1";
        String result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("\n1, ") && !result.contains("\n2, "));
    }

    @Test
    void punkt2() {
        /* 3. Получить список всех работников с именем 'David'*/
        String query = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME='David'";
        String result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("Dave") && !result.contains("Sheep"));
    }

    @Test
    void punkt3() {
        /*3. Получить список всех работников из 54го отдела с зарплатой, большей 5000*/
        String query = "SELECT * FROM EMPLOYEES, DEPARTMENTS WHERE EMPLOYEES.DEPARTMENT_ID=DEPARTMENTS.DEPARTMENT_ID AND DEPARTMENTS.DEPARTMENT_NAME=54 AND EMPLOYEES.SALARY > 5000";
        String result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("Shmavid"));
        assertTrue(result.contains("Hanks"));
        assertFalse(result.contains("Sheep"));
    }

    @Test
    void punkt4() {
        /*Получить список всех работников у которых последняя буква в имени 'd'*/
        String query = "SELECT * FROM EMPLOYEES where FIRST_NAME like '%d'";
        String result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("David"));
        assertTrue(result.contains("Shmavid"));
        assertFalse(result.contains("Dolly"));
    }

    @Test
    void punkt5() {
        /*Получить список всех работников у которых зарплата находится в промежутке от 2000 до 4000 (включительно)*/
        String query = "SELECT * FROM EMPLOYEES where SALARY >= 2000 and SALARY <= 4000";
        String result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("Grass"));
        assertTrue(result.contains("Sawier"));
        assertFalse(result.contains("Bush"));
        assertFalse(result.contains("Sheep"));
    }

    @Test
    void punkt6() {
        /*Получить список работников которые живут в Europe (region_name)*/
        String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY" +
                " FROM EMPLOYEES em, DEPARTMENTS dp, LOCATIONS lc, COUNTRIES cn, REGIONS rg" +
                " WHERE em.DEPARTMENT_ID=dp.DEPARTMENT_ID" +
                " and dp.LOCATION_ID = lc.LOCATION_ID" +
                " and lc.COUNTRY_ID = cn.COUNTRY_ID" +
                " and cn.REGION_ID = rg.REGION_ID" +
                " and rg.REGION_NAME = 'EUROPE'";


        String result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("Lessley"));
        assertTrue(result.contains("Dave"));
        assertFalse(result.contains("Bush"));
        assertFalse(result.contains("Sawier"));
    }

    @Test
    void punkt7() {
        /*Показать всех менеджеров которые имеют в подчинении больше 6ти работников*/
        String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY " +
                "FROM Employees em, (SELECT COUNT(EMPLOYEE_ID), MANAGER_ID FROM Employees GROUP BY MANAGER_ID HAVING COUNT(EMPLOYEE_ID) > 6) mn" +
                " WHERE mn.MANAGER_ID = em.EMPLOYEE_ID";

        String result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("Dave"));
        assertTrue(result.contains("Sheep"));
        assertFalse(result.contains("Bush"));
        assertFalse(result.contains("Sawier"));
    }

    @Test
    void punkt8() {
        /*Получить список работников у которых менеджер получает зарплату больше 10000*/
        String query = "SELECT * FROM EMPLOYEES empls, (SELECT EMPLOYEE_ID, SALARY FROM EMPLOYEES em, (SELECT MANAGER_ID as mngr FROM Employees GROUP BY MANAGER_ID) mngrs WHERE EMPLOYEE_ID = mngr AND SALARY >10000) richmngr WHERE empls.MANAGER_ID = richmngr.EMPLOYEE_ID";

        String result = runEmployeeRequest(query);
        log.info(result);
        assertTrue(result.contains("Sheep"));
        assertTrue(result.contains("Markovich"));
        assertFalse(result.contains("Grass"));
        assertFalse(result.contains("Shmony"));
        assertFalse(result.contains("Shmisty"));
    }

    String runEmployeeRequest(String query) {
        StringBuilder queryResult = new StringBuilder();
        queryResult.append("\n").append(query).append("\n");
        String result = "";

        try (Connection connection = DriverManager.getConnection(host + dataBaseName, username, password)) {
            try (Statement stmt = connection.createStatement()) {
                resultSet = stmt.executeQuery(query);
                while (resultSet.next()) {
                    String employeeId = resultSet.getString("EMPLOYEE_ID");
                    String firstName = resultSet.getString("FIRST_NAME");
                    String lastName = resultSet.getString("LAST_NAME");
                    int salary = resultSet.getInt("SALARY");
                    queryResult.append('\n').append(employeeId).append(", ").append(firstName).append(", ").append(lastName).append(", ").append(salary);
                }
            } catch (SQLException e) {
                log.error("Bad SQL " + e.toString());
                fail();
            }
        } catch (Exception ex) {
            log.error("Connection failed..." + ex.toString());
            fail();
        }
        queryResult.append('\n');
        return queryResult.toString();
    }
}