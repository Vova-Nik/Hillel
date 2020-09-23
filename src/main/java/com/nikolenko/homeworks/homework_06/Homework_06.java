package com.nikolenko.homeworks.homework_06;

import com.nikolenko.homeworks.homework_05.Order;

import java.util.Date;

public class Homework_06 {

    public static void main(String[] args) {

        System.out.println("HW6");
        FractionNumber fr = new FractionNumber();
        System.out.println(fr.toString());
        fr=null;
        FractionNumber fr12 = new FractionNumber(1, 2);
        FractionNumber fr_12 = new FractionNumber(1, 2);
        FractionNumber fr13 = new FractionNumber(1, 3);
        System.out.println("1/2 equals to 1/3 " +fr12.equals(fr13));
        System.out.println("1/2 equals to 1/2 " +fr12.equals(fr_12));

        System.out.println(fr13.getValue());

        FractionNumber fr10 = new FractionNumber(1, 0);
        System.out.println("1/0 == :) " + fr10.getValue());

        FractionNumber fr24 = new FractionNumber(8, 24);
        System.out.println(fr24.toPrintg());





    }
}
