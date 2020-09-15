package com.nikolenko.homeworks.homework_00;

import java.util.Scanner;

public class KeyBoard {
    public Scanner scanner;

    private double[] triangle = new double[3];


    public KeyBoard() {
        scanner = new Scanner(System.in);
    }

    public int giveInt() {
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

    public int giveMenu(){
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
        if(num>1000||num<=0){
            num =0;
        }
        scanner.nextLine();
        return num;
    }

    public int giveMenu(int max){
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
        if(num>max||num<=0){
            num =0;
        }
        scanner.nextLine();
        return num;
    }

    public double giveDouble() {
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
//        scanner.nextLine();
        while(true) {
        System.out.println(request);

        String input = scanner.nextLine();
        String[] splited = input.split("\\s+");

            try {
                pair[0] = Double.parseDouble(splited[0]);
                pair[1] = Double.parseDouble(splited[1]);
                break;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        System.out.println(success);

        return pair;
    }

    public double[] giveTriangle(String request, String err, String success) {
        double[] triangle = new double[3];
//        scanner.nextLine();
        while(true) {
            System.out.println(request);

            String input = scanner.nextLine();
            String[] splited = input.split("\\s+");

            try {
                triangle[0] = Double.parseDouble(splited[0]);
                triangle[1] = Double.parseDouble(splited[1]);
                triangle[2] = Double.parseDouble(splited[2]);
                break;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        System.out.println(success);

        return triangle;
    }

    public String giveString(){
       String str =  scanner.nextLine();
       return "str";
    }

    public void close() {
        scanner.close();
    }

}
