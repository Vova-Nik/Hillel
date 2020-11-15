package com.nikolenko.homeworks.homework_21;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class AverageTest {
    static int[] toCalculate = new int[1_000_000];
    static double oneThreadResult;
    static double multyThreadResult;

    @BeforeAll
    static void setUp() {
        Random r = new Random();
        for (int i = 0; i < toCalculate.length; i++) {
            toCalculate[i] = r.nextInt(1000) - 500;
        }
    }

    @Test
    void proceed() {
        double sum = 0;
        for (int next : toCalculate) {
            sum = sum + next;
        }
        oneThreadResult = sum / toCalculate.length;
        log.debug(String.valueOf(oneThreadResult));
        Average average = new Average(toCalculate);
        multyThreadResult = average.proceed();
        log.debug(String.valueOf(multyThreadResult));
        oneThreadResult = Math.round(oneThreadResult * 4.0) / 4.0;
        multyThreadResult = Math.round(multyThreadResult * 4.0) / 4.0;
        assertEquals(oneThreadResult, multyThreadResult);
    }

    @Test
    void speedTest() {
        long oneThreadDuration;
        long multiThreadDuration;
        long oneThreadBegin = System.nanoTime();
        double sum = 0;
        for (int next : toCalculate) {
            sum = sum + next;
        }
        oneThreadResult = sum / toCalculate.length;
        oneThreadDuration = System.nanoTime() - oneThreadBegin;

        long multyThreadBegin = System.nanoTime();
        Average average = new Average(toCalculate);
        multyThreadResult = average.proceed();
        multiThreadDuration = System.nanoTime() - multyThreadBegin;

        log.info("oneThreadDuration = " + oneThreadDuration);
        log.info("multiThreadDuration = " + multiThreadDuration);
        /*Array length where 4 threadth meke 1 thread is 16_000_000. Just my computer.*/
        assertTrue(oneThreadDuration < multiThreadDuration);

    }
}