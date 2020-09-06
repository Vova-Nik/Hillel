package com.nikolenko.homeworks.homework_01;

import java.util.ArrayList;
import java.util.Scanner;

public class KeyBoard {
    public Scanner scanner;

    private double[] triangle = new double[3];


    public KeyBoard() {
        scanner = new Scanner(System.in);
    }

    int giveInt() {
        int num;
        while (true) {
            try {
                num = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Only integer number, please");
                scanner.next();
                //num = 0;
            }
        }

        return num;
    }

    double giveDouble() {
        double num;
        while (true) {
            try {
                num = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Only  fractional number, please");
                scanner.next();
            }
        }
        return num;
    }

    public double[] givePair(String request, String err, String success) {
        double[] pair = new double[2];
        System.out.println(request);
        scanner.nextLine();
        String iput = scanner.nextLine();
        String[] splited = iput.split("\\s+");
        pair[0] = Double.parseDouble( splited[0] );
        pair[1] = Double.parseDouble( splited[1] );

        System.out.println("input = " + iput);

//        System.out.println("A = " + pair[0]);
//        System.out.println("B = " + pair[1]);
//        System.out.println(err);
        System.out.println(success);

        return pair;
    }

    public double[] giveTriangle(String request, String err) {
        System.out.println("request");
        triangle[0] = 1;
        triangle[1] = 2;
        triangle[3] = 3;
        System.out.println("err");
        return triangle;
    }

    void close() {
        scanner.close();
    }

}
