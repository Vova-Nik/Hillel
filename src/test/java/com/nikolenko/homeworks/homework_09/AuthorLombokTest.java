package com.nikolenko.homeworks.homework_09;

import com.nikolenko.homeworks.homework_08.Author;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AuthorLombokTest {
    static AuthorLombok twain;
    static AuthorLombok twainTwin;
    static AuthorLombok king;

    @BeforeAll
    static void setUp() {
        twain = new AuthorLombok("Mark", "Twain", new Date(1835,10,30));
        twainTwin = new AuthorLombok("Mark", "Twain", new Date(1835,10,30));
        king = new AuthorLombok("Stewen", "King", new Date(1947,8,21));

    }

    @Test
    void getFirstName() {
        assertEquals("Mark",twain.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Twain",twain.getLastName());
    }

    @Test
    void getDateOfBirth() {
        Date date = twain.getDateOfBirth();
        assertEquals(1835, date.getYear());
        assertEquals(10, date.getMonth());
        assertEquals(30, date.getDate());
        date.setYear(2000);
        assertEquals(1835, twain.getDateOfBirth().getYear());
    }

    @Test
    void testEquals() {
        assertTrue(twain.equals(twain));
        assertTrue(twain.equals(twainTwin));
        assertFalse(twain.equals(king));
    }

    @Test
    void testHashCode() {
        assertEquals(twain.hashCode(),twain.hashCode());
        assertEquals(twain.hashCode(),twainTwin.hashCode());
        assertNotEquals(twain.hashCode(),king.hashCode());
    }

    @Test
    void testToString() {
//        System.out.println(twain.toString());
        assertNotEquals("firstName=Mark, lastName=Twain, dateOfBirth=Wed Nov 30 00:00:00 EET 3735",twain.toString());
    }
}