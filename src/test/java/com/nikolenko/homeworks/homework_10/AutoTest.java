package com.nikolenko.homeworks.homework_10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

class AutoTest {
    static Auto auto;
    static Auto autoTwin;
    static Auto autoOtherTransport;
    static Auto autoOtherPerson;
    static Person person1;
    static Person person2;
    static Equipment equipmentEmpty;
    static Equipment equipmentCompl;

    @BeforeAll
    static void autoTestSetup() {
        person1 = new Person("John", "Smith");
        person2 = new Person("Tom", "Sowyer");
        equipmentEmpty = new Equipment();
        equipmentCompl = new Equipment(true, true, true, false, true);
        auto = new Auto(2006, Country.JP, "Toyota", 7000, equipmentCompl, new AutoCalendar(2017, Calendar.MARCH, 25), person1);
        autoTwin = new Auto(2006, Country.JP, "Toyota", 7000, equipmentCompl, new AutoCalendar(2017, Calendar.MARCH, 25), person1);
        autoOtherTransport = new Auto(2009, Country.JP, "Toyota", 7000, equipmentCompl, new AutoCalendar(2017, Calendar.MARCH, 25), person1);
        autoOtherPerson = new Auto(2006, Country.JP, "Toyota", 7000, equipmentCompl, new AutoCalendar(2017, Calendar.MARCH, 25), person2);
    }

    @Test
    void testEquals() {
        assertTrue(auto.equals(auto));
        assertTrue(auto.equals(autoTwin));
        assertFalse(auto.equals(autoOtherTransport));
        assertFalse(auto.equals(autoOtherPerson));
    }

    @Test
    void testHashCode() {
        assertEquals(auto.hashCode(), auto.hashCode());
        assertEquals(auto.hashCode(), autoTwin.hashCode());
        assertNotEquals(auto.hashCode(), autoOtherPerson.hashCode());
        assertNotEquals(auto.hashCode(), autoOtherTransport.hashCode());
    }

    @Test
    void testToString() {
        System.out.println(auto);
        assertTrue(auto.toString().contains("2006"));
        assertTrue(auto.toString().contains("Smith"));
        assertTrue(auto.toString().contains("25.03.2017"));
        assertTrue(auto.toString().contains("conditioner=true"));
    }
}