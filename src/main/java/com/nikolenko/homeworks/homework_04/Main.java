package com.nikolenko.homeworks.homework_04;

import com.nikolenko.homeworks.homework_00.ArrayGenerator;
import com.nikolenko.homeworks.homework_00.KeyBoard;

import static java.lang.System.arraycopy;

public class Main {
    private static KeyBoard keyBoard = new KeyBoard();
    private static ArrayGenerator arrayGenerator = new ArrayGenerator();

    /**
     * Homework 4
     */

    public static void main(String[] args) {
        System.out.println("Task1");
        System.out.println("Write a program which ﬁnds minimal number in int array");
        System.out.println(l03Task1());

        System.out.println("Task2");
        System.out.println("\nWrite a program which checks if a string (array of chars) is a palindrome");
        //        Аргентина манит негра А собака боса
        //        String poly = "А %%%стерва67* врет1 #$";
        //        String poly = "AbcbA";
        //        String poly = "Аргентина манит негра";
        //        String poly = "Аргентина анит негра";
        //        String poly = "А собака боса";

        KeyBoard keyBoard = new KeyBoard();
        System.out.println("Input any string to check, if it is a palindrome");
        String poly = keyBoard.giveString();
        keyBoard.close();

        if (l03Task2(poly)) {
            System.out.println("Phrase: " + '\"' + poly + '\"' + " is true palindrome");
        } else {
            System.out.println("Phrase: " + '\"' + poly + '\"' + " is not a palindrome");
        }
        keyBoard.close();
    }

    private static String l03Task1() {
        int arrSize = 24;
        int[] inArray = arrayGenerator.giveIntArray(arrSize, 0, 100);
        StringBuilder result = new StringBuilder();
        for (int value : inArray) {
            result.append(value).append("\t");
        }
        int minVal = Integer.MAX_VALUE;
        for (int value : inArray) {
            if (value < minVal) {
                minVal = value;
            }
        }
        result.append("\n");
        result.append("minimal number in the array is  ").append(minVal);
        return result.toString();
    }

    private static boolean l03Task2(String string) {
        if (string.length() <= 1) {
            return false;
        }
        System.out.println("Original = " + string);

        String lovercased = string.toLowerCase();
        char[] stringCharArr = lovercased.toCharArray();
        char[] stringCleared = new char[stringCharArr.length];
        int normLength = 0;
        for (char c : stringCharArr) {
            if ((int) c > 0x60) {
                stringCleared[normLength] = c;
                normLength++;
            }
        }
        char[] normalized = new char[normLength];
        arraycopy(stringCleared, 0, normalized, 0, normLength); //truncation. Tail free array items removed

        for (int i = 0, j = normLength - 1; i < normLength / 2 + 1; i++, j--) {
            //System.out.println(normalized[i] + "\t" + normalized[j]);       //logging, in case of debugging necessity
            if (normalized[i] != normalized[j]) {
                return false;
            }
        }
        return true;
    }
}
