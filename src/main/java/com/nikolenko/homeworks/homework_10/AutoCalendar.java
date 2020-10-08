package com.nikolenko.homeworks.homework_10;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AutoCalendar extends GregorianCalendar {

   public AutoCalendar(AutoCalendar ac) {
        super(ac.get(Calendar.YEAR), ac.get(Calendar.MONTH), ac.get(Calendar.DATE), 0, 0, 0);
    }

    public AutoCalendar(int year, int month, int date) {
        super(year, month, date, 0, 0, 0);
    }

    @Override
    public String toString() {
        String month = String.valueOf(get(Calendar.MONTH) + 1);
        if (month.length() < 2) {
            month = '0' + month;
        }
        return String.valueOf(get(Calendar.DATE)) + '.' + month + '.' + get(Calendar.YEAR);
    }
}
