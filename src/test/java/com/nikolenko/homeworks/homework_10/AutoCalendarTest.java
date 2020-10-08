package com.nikolenko.homeworks.homework_10;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class AutoCalendarTest {

    @Test
    void testToString() {
        AutoCalendar autoCalendar = new AutoCalendar(2011, Calendar.MARCH, 25);
        AutoCalendar autoCalendar1 = new AutoCalendar(2011, Calendar.DECEMBER, 25);
        AutoCalendar autoCalendar2 = new AutoCalendar(2011, Calendar.JANUARY, 25);
        assertTrue(autoCalendar.toString().equals("25.03.2011"));
        assertTrue(autoCalendar1.toString().equals("25.12.2011"));
        assertTrue(autoCalendar2.toString().equals("25.01.2011"));
        System.out.println(autoCalendar1);

    }
}