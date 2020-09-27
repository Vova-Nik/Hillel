package com.nikolenko.homeworks.homework_06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FractionTestV1 {
   static FractionImpl fraction1_2;
   static FractionImpl fraction6_21;
   static FractionImpl fraction1_3;
   static FractionImpl fraction2_2;
   static FractionImpl fraction3_4;
   static FractionImpl fraction_3_4;
   static FractionImpl fraction0_4;
   static FractionImpl fraction0_8;

    @BeforeAll
    static void setup() {
        fraction1_2 = new FractionImpl(1, 2);
        fraction6_21 = new FractionImpl(6, 21);
        fraction_3_4 = new FractionImpl(-3, 4);
        fraction1_3 = new FractionImpl(1, 3);
        fraction2_2 = new FractionImpl(1, 2);
        fraction3_4 = new FractionImpl(3, 4);
        fraction0_4 = new FractionImpl(0, 4);
        fraction0_8 = new FractionImpl(0, 8);
    }


    @Test
    void plus() {
        Fraction result = fraction1_2.plus(fraction1_2);
            assertEquals(1, result.getNumerator());
            assertEquals(1, result.getDenominator());
        Fraction result1 = fraction3_4.plus(fraction6_21);
            assertEquals(29, result1.getNumerator());
            assertEquals(28, result1.getDenominator());
        Fraction result3 = fraction0_4.plus(fraction0_8);
            assertEquals(0, result3.getNumerator());
            assertEquals(1, result3.getDenominator());
        Fraction result4 = fraction1_3.plus(fraction_3_4);
            assertEquals(-5, result4.getNumerator());
            assertEquals(12, result4.getDenominator());
    }

    @Test
    void minus() {
        Fraction result = fraction1_2.minus(fraction1_2);
            assertEquals(0, result.getNumerator());
            assertEquals(1, result.getDenominator());
        Fraction result1 = fraction6_21.minus(fraction3_4);
            assertEquals(-13, result1.getNumerator());
            assertEquals(28, result1.getDenominator());
        Fraction result3 = fraction0_4.minus(fraction0_8);
            assertEquals(0, result3.getNumerator());
            assertEquals(1, result3.getDenominator());
        Fraction result4 = fraction1_2.minus(fraction1_3);
            assertEquals(1, result4.getNumerator());
            assertEquals(6, result4.getDenominator());
        Fraction result5 = fraction1_2.minus(fraction_3_4);
            assertEquals(5, result5.getNumerator());
            assertEquals(4, result5.getDenominator());
    }


    @Test
    void multiply() {
        Fraction result = fraction1_2.multiply(fraction1_2);
            assertEquals(1, result.getNumerator());
            assertEquals(4, result.getDenominator());
        Fraction result1 = fraction0_4.multiply(fraction6_21);
            assertEquals(0, result1.getNumerator());
            assertEquals(1, result1.getDenominator());
        Fraction result3 = fraction0_4.multiply(fraction0_8);
            assertEquals(0, result3.getNumerator());
            assertEquals(1, result3.getDenominator());
        Fraction result4 = fraction1_2.multiply(fraction_3_4);
            assertEquals(-3, result4.getNumerator());
            assertEquals(8, result4.getDenominator());
    }

    @Test
    void divide() {
        Fraction result = fraction1_2.divide(fraction1_2);
            assertEquals(1, result.getNumerator());
            assertEquals(1, result.getDenominator());
        Fraction result1 = fraction0_4.divide(fraction6_21);
            assertEquals(0, result1.getNumerator());
            assertEquals(1, result1.getDenominator());
        Fraction result4 = fraction1_2.divide(fraction_3_4);
            assertEquals(-2, result4.getNumerator());
            assertEquals(3, result4.getDenominator());
    }
    @Test
    void testHashcode() {
        assertEquals(0x00020007, fraction6_21.hashCode());
        assertEquals(-3*0x10000+4, fraction_3_4.hashCode());
    }

    @Test
    void testEquals() {
        assertTrue(fraction6_21.equals(fraction6_21));
        assertTrue(fraction6_21.equals(new FractionImpl(2, 7)));
        assertFalse(fraction6_21.equals(fraction1_2));
    }

    @Test
     void testToString(){
            assertEquals("1/2", fraction1_2.toString());
    }

    @Test
    void testDenominatorZerro() {
        try {
            FractionImpl fraction1_0 = new FractionImpl(1,0);
            fail();
        } catch (ArithmeticException e) {
            assertTrue(e.getMessage().contains(("by zero")));
        }
    }

}