package com.nikolenko.homeworks.homework_01;

import java.io.IOException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//import Chapt9.Chapter9;
//import Chapter111.Dispatch;
//import Chapter12.StudyAnnotations;

public class Main {
//    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String greeting = "Welcome Hillel, Java course, Homework_01 Nikolenko!";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++)
            System.out.print("=");
        System.out.println();
        KeyBoard keyBoard = new KeyBoard();

        while (true) {
            System.out.println("Input a number: ");
            System.out.println("1 - First part ex. 19 to 26");
            System.out.println("2 - Logarithm of b with the base of a");
            System.out.println("3 - Heron's formula to calculate area of triangle");
            System.out.println("4 - Quadratic equation");
            System.out.println("0 - To exit program");

            int num = keyBoard.giveInt();
            if (num == 0) {
                break;
            }
            switch (num) {
                case 1:
                    System.out.println("Case: 1");
                    Equations19_26 equations19_26 = new Equations19_26(keyBoard);
                    break;
                case 2:
                    System.out.println("Case: 2");
                    break;
                case 3:
                    System.out.println("Case: 3");
                    break;
                case 4:
                    System.out.println("Case: 4");
                    break;


                default:
                    break;
            }

        }
        keyBoard.close();
//            scanner.close();
//        public static void firstPart (Scanner scanner){
//            System.out.println("Please, enter any number as X for calculating functions");
//            int x = scanner.nextInt();
//            System.out.println("x = " + x);
    }

}
