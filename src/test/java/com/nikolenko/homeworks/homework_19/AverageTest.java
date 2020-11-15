package com.nikolenko.homeworks.homework_19;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

@Slf4j
class AverageTest {
    static int[] toCalculate = new int[1_000_000];
    double oneThreadResult;
    double multyThreadResult;

    @BeforeAll
    static void setUp() {
        Random r = new Random();
        for (int i = 0; i < toCalculate.length; i++) {
            toCalculate[i] = r.nextInt(1000)-500;
        }
    }

    @Test
    void oneThreadAverage() {
        log.info("oneThreadAverage test beginning");
        oneThreadResult = Average.oneThreadAverage(toCalculate);
        log.info("oneThreadAverage test end");
        log.info("oneThreadResult " + oneThreadResult);
    }

    @Test
    void multyThreadAverage() {
        log.info("multyThreadAverage test beginning");
        try {
            multyThreadResult = Average.multyThreadAverage(toCalculate);
        }catch(AverageInputDataException e){
            fail("Bad array length");
        }
        log.info("multyThreadAverage test end");
        log.info("multyThreadResult " + multyThreadResult);
    }

}