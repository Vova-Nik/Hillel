package com.nikolenko.homeworks.homework_06;

public class Homework_06 {

    public static void main(String[] args) {
        FractionNumber fr14 = new FractionNumber(1, 4);
        FractionNumber fr12 = new FractionNumber(1, 2);

        System.out.println("1/4 func 1/2:");

        System.out.println("plus = " + fr12.plus(fr14));
        System.out.println("minus = " + fr12.minus(fr14));
        System.out.println("multiply = " + fr12.multiply(fr14));
        System.out.println("divide = " + fr12.divide(fr14));

        System.out.println("equals - " + fr14.equals(fr12));

    }
}
