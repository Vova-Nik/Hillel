package com.nikolenko.homeworks.homework_01;

public class LogBBaseA {
    private KeyBoard keyBoard;
    LogBBaseA(KeyBoard kbd){
        keyBoard = kbd;
        double[] pair;
        pair = keyBoard.givePair("Input pair of double values as \"a\" and \"b\" separated by \"space\"", "Impossible to translate to pair of double values, try again", "It's OK, Thanks!");
        double y = Math.log10(pair[1])/Math.log10(pair[0]);
        System.out.println("a = " + pair[0] + " b = " + pair[1]);
        System.out.println("logarithm " + pair[1] + " by base " +  pair[0] + " = " + y  );
    }



}
