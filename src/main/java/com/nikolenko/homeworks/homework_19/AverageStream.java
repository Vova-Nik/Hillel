package com.nikolenko.homeworks.homework_19;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class AverageStream {
    public static double oneThreadAverage(int[] arrayToCalculate) {
        double sum = 0;
        for (int next : arrayToCalculate) {
            sum = sum + next;
        }
        return sum / arrayToCalculate.length;
    }

    public static double streamAverage(int[] arrayToCalculate) throws IllegalArgumentException{
        IntStream numbersStream = Arrays.stream(arrayToCalculate);
        OptionalInt result = numbersStream.reduce(Integer::sum);
        int res;
        if(result.isPresent()){
           res = result.getAsInt();
        }
        else {
            throw(new IllegalArgumentException("streamAverage\nBad data in input array for average calc."));
        }

        return res*1.0/(arrayToCalculate.length);
    }

    public static double streamParallelAverage(int[] arrayToCalculate) throws IllegalArgumentException{
        IntStream numbersStream = Arrays.stream(arrayToCalculate);
        OptionalInt result = numbersStream.parallel().reduce(Integer::sum);
        int res;
        if(result.isPresent()){
            res = result.getAsInt();
        }
        else {
            throw(new IllegalArgumentException("streamAverage\nBad data in input array for average calc."));
        }

        return res*1.0/(arrayToCalculate.length);
    }
}
