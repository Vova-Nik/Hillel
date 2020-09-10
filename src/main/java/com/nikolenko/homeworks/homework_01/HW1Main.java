package com.nikolenko.homeworks.homework_01;

import com.nikolenko.homeworks.homework_00.KeyBoard;

public class HW1Main {
    static KeyBoard keyBoard;

    public static void main(String[] args) {
        String greeting = "Welcome Hillel, Java course, Homework_01 Nikolenko!";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++)
            System.out.print("=");
        System.out.println();
        keyBoard = new KeyBoard();

        nathan();
        System.out.println(bmi());


        keyBoard.close();
    }

    private static void nathan() {
        System.out.println("Practice 1. 'Nathan loves cycling'");
        System.out.println("Please, enter any number XX,XXX as hours");
        double nHours = keyBoard.giveDouble();
        int liters = (int) Math.floor(nHours * 0.5);
        String lit = liters > 1 ? " liters." : " liter.";
        System.out.print("Nathan should drink at least " + liters + lit);
        if (liters > 3) {
            System.out.println(" Natans life is in danger");
        }
        System.out.println("\n ===============================================");
    }

    public static String bmi() {
        System.out.println("Practice 2. '(bmi = weight / height ^ 2').");
        System.out.println("Please, enter Your weight in kilograms. (any number XX,XXX)");
        double weight = keyBoard.giveDouble();
        System.out.println("Please, enter Your height in meters. (any number XX,XXX m)");
        double height = keyBoard.giveDouble();
        System.out.println("weight = " + weight + " height = " + height);
        double bmi = weight / (height * height);
        System.out.println("Your BMI = " + bmi);
        /*
            if bmi <= 18.5 return "Underweight"
            if bmi <= 25.0 return "Normal"
            if bmi <= 30.0 return "Overweight"
            if bmi > 30 return "Obese"
        */

        if (bmi <= 18.5){return "Underweight";}
        if (bmi > 18.5 && bmi <= 25.0) { return "Normal";}
        if (bmi > 25.0 && bmi <= 30.0) {return "Overweight";}
        if (bmi > 30) {return "Obese";}

        return "Unknown error";
    }
}
