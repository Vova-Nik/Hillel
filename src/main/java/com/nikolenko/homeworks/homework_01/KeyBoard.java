package com.nikolenko.homeworks.homework_01;

import java.util.Scanner;

public class KeyBoard {
    public Scanner scanner;

    public KeyBoard() {
        scanner = new Scanner(System.in);
    }

    int giveInt() {
        int num;
         while(true) {
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

    void close(){
        scanner.close();
    }

}
