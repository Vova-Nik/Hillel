package com.nikolenko.homeworks.homework_05;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class main {

    public static void main(String[] args) {

        Order orderDef = new Order();
        System.out.println("Order default " + orderDef);

        Date dt = new Date();
        dt.setTime(dt.getTime() + 86400000);
        Order order = new Order("Pizza", dt, 1200,120 );
        System.out.println("Order spec " + order);
    }
}





