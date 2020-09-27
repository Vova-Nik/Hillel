package com.nikolenko.homeworks.homework_07;

import com.nikolenko.homeworks.homework_06.Fraction;
import com.nikolenko.homeworks.homework_06.FractionImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FractionTest {
    private static Fraction fraction1;
    private static Fraction fraction2;
    private static Fraction fraction3;

    @BeforeAll
    static void setUp() {
        fraction1 = new FractionImpl(1, 3);
        fraction2 = new FractionImpl(2, 3);
        fraction3 = new FractionImpl(3, 4);
    }

    @Test
    void badFractionCreation() {
        assertThrows(IllegalArgumentException.class,() -> new FractionImpl(1,0));
    }

    @Test
    void testEquals() {
        assertEquals(new FractionImpl(1, 3), fraction1);
        assertNotEquals(fraction2, fraction1);
        assertEquals(new FractionImpl(3, 9), fraction1);
        assertEquals(new FractionImpl(3, 1), new FractionImpl(9, 3));
    }

    @Test
    void testPlusWithTheSameDenominator() {
        Fraction result = fraction1.plus(fraction2);
        assertEquals(new FractionImpl(3,3),result);
        assertEquals(new FractionImpl(1,1),result);
    }

    @Test
    void testPlusWithNotTheSameDenominator() {
        Fraction result = fraction1.plus(fraction3);
        assertEquals(new FractionImpl(13,12),result);
    }

    @Test
    void minus() {
        fail("Not implemented");
    }

    @Test
    void multiply() {
        fail("Not implemented");
    }

    @Test
    void divide() {
        fail("Not implemented");
    }
}