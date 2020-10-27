package com.nikolenko.homeworks.homework_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person1;
    Person person2;
    Person person3;

    @BeforeEach
    void setUp() {
            person1 = new Person("Mike","Tyson",54,178,81,"iron.mike@gmail.com");
            person2 = new Person("Mike","Tyson",54,178,81,"iron.mike@gmail.com");
            person3 = new Person("Nik","Tyson",34,178,81,"iron.mike@gmail.com");
    }

    @Test
    void testToString() {
        System.out.println(person1);
        assertTrue(person1.toString().contains("iron.mike@gmail.com"));
    }

    @Test
    void getName() {
        assertEquals("Mike", person1.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Tyson", person1.getSurname());
    }

    @Test
    void getAge() {
        assertEquals(54, person1.getAge());
    }

    @Test
    void getWeight() {
        assertEquals(81, person1.getWeight());
    }

    @Test
    void getHeight() {
        assertEquals(178, person1.getHeight());
    }

    @Test
    void getMail() {
        assertEquals("iron.mike@gmail.com", person1.getMail());
    }

    @Test
    void getDomain() {
        assertEquals("gmail.com", person1.getDomain());
    }

    @Test
    void testEquals() {
        assertEquals(person1, person2);
        assertNotEquals(person1, person3);
    }
}