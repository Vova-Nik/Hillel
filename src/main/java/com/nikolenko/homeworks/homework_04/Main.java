package com.nikolenko.homeworks.homework_04;

import com.nikolenko.homeworks.homework_00.InputGenerator;
import com.nikolenko.homeworks.homework_00.KeyBoard;

import static java.lang.System.arraycopy;

public class Main {
    private static KeyBoard keyBoard = new KeyBoard();
    private static InputGenerator inputGenerator = new InputGenerator();

    /**
     * Homework 4
     */

    public static void main(String[] args) {

        /* ************************************************* minimal number in int array *************************************************************/

        System.out.println("Task1");
        System.out.println("Write a program which ﬁnds minimal number in int array");
        System.out.println(l03Task1());
        System.out.println("\n*********************************************************************************");


        /* ************************************************* palindrome *************************************************************/
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


        if (l03Task2(poly)) {
            System.out.println("Phrase: " + '\"' + poly + '\"' + " is true palindrome");
        } else {
            System.out.println("Phrase: " + '\"' + poly + '\"' + " is not a palindrome");
        }
        System.out.println("\n*********************************************************************************");

        /* ************************************************* sum of arrays *************************************************************/
        System.out.println("Task3");
        System.out.println("\nWrite a program which calculates the sum of two columns.\n" +
                "Print table with results if columns have the same size (col_1\n" +
                "| col_2 | sum). Otherwise print which column has bigger size");
        InputGenerator inputGenerator = new InputGenerator();
        System.out.println(l03Task3(inputGenerator.giveIntArray(10), inputGenerator.giveIntArray(10)));
        System.out.println(l03Task3(inputGenerator.giveIntArray(10), inputGenerator.giveIntArray(12)));

        System.out.println("\n*********************************************************************************");

        /*
                Write a program which checks if given number is
                STRONG, i.e. the sum of the factorials of its digits is equal
                to number itself: 1! + 4! + 5! = 1 + 24 + 120 = 145
         */

        /* ******************************if given number is STRONG **************************************************/





        keyBoard.close();
    }

    private static String l03Task1() {
        int arrSize = 24;
        int[] inArray = inputGenerator.giveIntArray(arrSize, 0, 100);
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

    private static String l03Task3(int[] arr1, int[] arr2) {

        StringBuilder result = new StringBuilder();
        if (arr1.length > arr2.length) {
            return "Array 1 has bigger size ";
        }
        if (arr2.length > arr1.length) {
            return "Array 2 has bigger size ";
        }
        result.append("Arrays have equal length\n");
        result.append("|A1\t|A2\t| ∑\n");
        result.append("---------------\n");
        for (int i = 0; i < arr1.length; i++) {
            result.append("|").append(arr1[i]).append("\t|").append(arr2[i]).append("\t|").append(arr1[i] + arr2[i]).append("\n");
        }

        return result.toString();
    }
}
