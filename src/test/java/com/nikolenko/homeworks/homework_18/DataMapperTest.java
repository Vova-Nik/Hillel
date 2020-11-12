package com.nikolenko.homeworks.homework_18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataMapperTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void mapString() {
        Person person1 = new Person("Mike", "Tyson", 54, 178, 81, "iron.mike@gmail.com");
        try {
            Person person2 = DataMapper.mapString("Mike,Tyson,54,178,81,iron.mike@gmail.com");
            assertEquals(person1.toString(), person2.toString());
        } catch (PersonFailException e) {
            fail();
        }

        try {
            Person person2 = DataMapper.mapString("Mike,Tyson,54,178,iron.mike@gmail.com");
        } catch (PersonFailException e) {
            assertTrue(true);
            assertTrue(e.toString().contains("Tyson"));
            assertFalse(e.toString().contains("ArrayIndexOutOfBoundsException"));
        }

    }
}