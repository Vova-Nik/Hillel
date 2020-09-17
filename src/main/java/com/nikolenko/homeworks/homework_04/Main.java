package com.nikolenko.homeworks.homework_04;

import com.nikolenko.homeworks.homework_00.KeyBoard;

import static java.lang.System.arraycopy;
import static java.lang.System.in;

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
        KeyBoard keyBoard = new KeyBoard();
        //System.out.println("Input any string to check, if it is a palindrome");
        //String poly = keyBoard.giveString();

        String poly = "tenet";
        if (l03Task2(poly)) {
            System.out.println("Phrase: " + '\"' + poly + '\"' + " is true palindrome");
        } else {
            System.out.println("Phrase: " + '\"' + poly + '\"' + " is not a palindrome");
        }
        poly = "Аргентина, манит негра!!!";
        if (l03Task2(poly)) {
            System.out.println("Phrase: " + '\"' + poly + '\"' + " is true palindrome");
        } else {
            System.out.println("Phrase: " + '\"' + poly + '\"' + " is not a palindrome");
        }
        poly = "А стерва!";
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

        System.out.println(l03Task3(inputGenerator.giveIntArray(10), inputGenerator.giveIntArray(10)));
        //System.out.println(l03Task3(inputGenerator.giveIntArray(10), inputGenerator.giveIntArray(12)));

        System.out.println("\n*********************************************************************************");

        /*
                Write a program which checks if given number is
                STRONG, i.e. the sum of the factorials of its digits is equal
                to number itself: 1! + 4! + 5! = 1 + 24 + 120 = 145
         */

        /* ******************************if given number is STRONG **************************************************/
        System.out.println("\nif given number is STRONG");
        int toCheck;
        toCheck = inputGenerator.giveInt(0, 5053607);  //4053607
        System.out.println(l03Task4(toCheck));
        toCheck = inputGenerator.giveInt(0, 5053607);
        System.out.println(l03Task4(toCheck));
        toCheck = inputGenerator.giveInt(0, 4053607);
        System.out.println(l03Task4(toCheck));
        System.out.println(l03Task4(toCheck));
        toCheck = inputGenerator.giveStrong();
        System.out.println(l03Task4(toCheck));
        toCheck = inputGenerator.giveStrong();
        System.out.println(l03Task4(toCheck));
        toCheck = inputGenerator.giveStrong();
        System.out.println(l03Task4(toCheck));
        toCheck = inputGenerator.giveStrong();
        System.out.println(l03Task4(toCheck));
        System.out.println("\n*********************************************************************************");

        System.out.println("\nRevert word");
        String s = "Vovchik!";
        System.out.println(s);
        System.out.println(l04Task0(s));
        s = inputGenerator.giveString();
        System.out.println(s);
        System.out.println(l04Task0(s));
        s = inputGenerator.giveString();
        System.out.println(s);
        System.out.println(l04Task0(s));

        System.out.println("\n*********************************************************************************");

        System.out.println("\nStringUtils");
        System.out.println(StringUtils.randomString(24,"alpha" ));
        System.out.println(StringUtils.randomString(32,"numeric" ));
        System.out.println(StringUtils.randomString(48,"alphanumeric" ));
        System.out.println(StringUtils.randomString(24,"unknown" ));
        System.out.println(StringUtils.randomString(-13,"alphanumeric" ));
        System.out.println("\n*********************************************************************************");

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


    private static String l03Task4(int numToCheck) {
        int toCheck = numToCheck;
        StringBuilder result = new StringBuilder();

        if (toCheck > 40353607) //there are no factorions bigger then 7^9
        {
            result.append("Number ").append(numToCheck).append(" is too big. Try another.\n\n");
            return result.toString();
        }
        if (toCheck < 0) {
            result.append("Number is too little. It is definitely not a STRONG.");
            return result.toString();
        }
        result.append("Checking number ").append(numToCheck).append("\n");

        /* parsing e.g 145 -> 1, 4, 5 in int[] array */
        int[] parsed = new int[8];
        for (int i = 0, j = 10000000; i < 7; i++, j = j / 10) {
            parsed[i] = toCheck / j;
            toCheck = toCheck - parsed[i] * j;
        }
        parsed[7] = toCheck % 10;

        /* finding real size of number size 145 is 3, size 4567 is 4  size 00056 is 2*/
        int size = 8;
        for (int i = 0; i < 8; i++) {
            if (parsed[i] == 0) {
                size--;
                continue;
            }
            break;
        }
//        System.out.println("size " + size);

        int calc = 0;
        int cc;
        for (int i = 8 - size; i < 8; i++) {
            cc = factorial(parsed[i]);
            calc += cc;
            result.append(cc).append("\n");
        }

        result.append("----------\n").append(calc).append("\n");

        if (numToCheck == calc) {
            result.append("Number ").append(numToCheck).append(" is STRONG");
        } else {
            result.append("Number ").append(numToCheck).append(" is not strong");
        }
        result.append("\n\n");
        return result.toString();
    }

    public static int factorial(int number) {
        int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }

    /*Lecture4 Task 0. Write a program which reverts given word*/
    private static String l04Task0(String toRevert) {
        StringBuilder rezult = new StringBuilder();
        for (int i = toRevert.length() - 1; i >= 0; i--) {
            rezult.append((toRevert.charAt(i)));
        }
        return rezult.toString();
    }

}
