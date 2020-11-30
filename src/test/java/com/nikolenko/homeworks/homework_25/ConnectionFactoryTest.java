package com.nikolenko.homeworks.homework_25;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ConnectionFactoryTest {
    @Test
    void getConnection() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            assertTrue(connection.isValid(0));
        } catch (SQLException e) {
            log.error("ConnectionFactoryTest " + Arrays.toString(e.getStackTrace()));
            fail();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            log.error("ConnectionFactoryTest " + Arrays.toString(e.getStackTrace()));
            fail();
        }
        Connection connectionCopy = ConnectionFactory.getConnection();
        assertEquals(connection, connectionCopy);
        ConnectionFactory.close();
    }

    @Test
    void getStatement() {
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = ConnectionFactory.getStatement();
        assertFalse(statement == null);

        /* Cecking if  ResultSet can be reused */
        ResultSet rs = ConnectionFactory.getResultSet("SELECT * FROM city WHERE Population <5000");
        int size = 0;
        if (rs != null) {
            try {
                while (rs.next()) {
                    size++;
                }
            } catch (SQLException e) {
                fail();
            }
        }
        assertTrue(size > 1);
        rs = ConnectionFactory.getResultSet("SELECT * FROM city WHERE CountryCode like '_KR'");
        if (rs != null) {

            try {
                while (rs.next()) {
                    size++;
                }
            } catch (SQLException e) {
                fail();
            }
            assertTrue(size > 1);
            ConnectionFactory.close();
        }
    }

}