package com.nikolenko.homeworks.homework_01;

public class HeronsEquition {
    HeronsEquition(KeyBoard kbd) {
        double[] triangle = kbd.giveTriangle("Input three double values for sides of triangle 'a', 'b', 'c' separated by 'space' ", "Impossible to translate to pair of double values, try again", "It's OK, Thanks!");
        double a = triangle[0];
        double b = triangle[1];
        double c = triangle[2];
        double p = (a + b + c) / 2;
        double square = Math.pow(Math.abs(p * (p - a) * (p - b) * (p - c)), 1d / 2);
        System.out.println("a = " + a + ", b = " + b + ", c = " + c + " ");
        System.out.println("Triangle square = " + square);

    }
}
