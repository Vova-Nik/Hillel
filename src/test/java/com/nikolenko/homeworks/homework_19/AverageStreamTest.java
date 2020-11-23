package com.nikolenko.homeworks.homework_19;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class AverageStreamTest {
    static int[] toCalculate = new int[1_000_000];
    double oneThreadResult;
    double multyThreadResult;

    @BeforeAll
    static void setUp() {
        Random r = new Random();
        for (int i = 0; i < toCalculate.length; i++) {
            toCalculate[i] = r.nextInt(1000) - 500;
        }
    }

    @Test
    void oneThreadAverage() {
        long begTime = System.nanoTime();
        oneThreadResult = AverageStream.oneThreadAverage(toCalculate);
        log.info("Usual one thread Elapsed time - " + stringify(System.nanoTime() - begTime));
        log.info("oneThreadResult " + oneThreadResult);
    }

    @Test
    void streamAverage() {
        long begTime = System.nanoTime();
        double result = 0;
        try {
            result = AverageStream.streamAverage(toCalculate);
        } catch (IllegalArgumentException e) {
            fail("Bad array");
        }
        log.info("One thread Stream Elapsed time - " + stringify(System.nanoTime() - begTime));
        log.info("multyThreadResult " + result);
    }

    @Test
    void parallelStreamAverage() {
        long begTime = System.nanoTime();
        double result = 0;
        try {
            result = AverageStream.streamParallelAverage(toCalculate);
        } catch (IllegalArgumentException e) {
            fail("Bad array");
        }
        log.info("Parallel Stream Elapsed time - " + stringify(System.nanoTime() - begTime));
        log.info("multyThreadResult " + result);
    }

    String stringify(double d){
        DecimalFormat dF = new DecimalFormat( "###,###.###" );
        return dF.format(d) + " ns";
    }
}