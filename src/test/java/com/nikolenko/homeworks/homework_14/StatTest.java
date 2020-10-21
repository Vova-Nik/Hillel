package com.nikolenko.homeworks.homework_14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatTest {
    Stat<Byte> statByte1;
    Stat<Short> statShort1;
    Stat<Integer> statInt1;
    Stat<Integer> statInt2;
    Stat<Long> statLong1;
    Stat<Double> statDouble1;
    Stat<Float> statFloat1;

    @BeforeEach
    void init(){
        Byte[] arrByte1 = {1,2,3,4,5,6};
        statByte1 = new Stat<>(arrByte1);

        Short[] arrShort1 = {1,2,3,4,5,6};
        statShort1 = new Stat<>(arrShort1);

        Integer[] arrint1 = {1,2,3,4,5,6};
        statInt1 = new Stat<>(arrint1);

        Integer[] arrint2 = {1,2,3,4,5,6,7};
        statInt2 = new Stat<>(arrint2);

        Long[] arrLong1 = {1L,2L,3L,4L,5L,6L};
        statLong1 = new Stat<>(arrLong1);

        Double[] arrdouble1 = {1.0,2.0,3.0,4.0,5.0,6.0};
        statDouble1 = new Stat<>(arrdouble1);

        Float[] arrfloat = {1.0F,2.0F,3.0F,4.0F,5.0F,6.0F};
        statFloat1 = new Stat<>(arrfloat);
    }

    @Test
    void printData() {
        statByte1.printData();
        statShort1.printData();
        statInt1.printData();
        statInt2.printData();
        statLong1.printData();
        statDouble1.printData();
        statFloat1.printData();
    }

    @Test
    void average() {
        assertEquals(3.5,statByte1.average());
        assertEquals(3.5,statShort1.average());
        assertEquals(3.5,statInt1.average());
        assertEquals(3.5,statLong1.average());
        assertEquals(3.5,statDouble1.average());
        assertEquals(3.5,statFloat1.average());
        assertEquals(4,statInt2.average());
    }

    @Test
    void isSameAverage() {
        assertTrue(statByte1.isSameAverage(statShort1));
        assertTrue(statLong1.isSameAverage(statShort1));
        assertTrue(statFloat1.isSameAverage(statShort1));
        assertTrue(statDouble1.isSameAverage(statInt1));
        assertTrue(statByte1.isSameAverage(statShort1));
        assertTrue(statByte1.isSameAverage(statFloat1));
        assertTrue(statFloat1.isSameAverage(statFloat1));
        assertFalse(statInt1.isSameAverage(statInt2));
    }
}
