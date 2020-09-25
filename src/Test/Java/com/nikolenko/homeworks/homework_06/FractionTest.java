package Java.com.nikolenko.homeworks.homework_06;

import com.nikolenko.homeworks.homework_06.Fraction;
import com.nikolenko.homeworks.homework_06.FractionImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void constructor() {
        FractionImpl fraction1 = new FractionImpl(1,2);
        assertEquals(1,fraction1.getNumerator());
        assertEquals(2,fraction1.getDenominator());
        FractionImpl fraction2 = new FractionImpl(6,21);
        assertEquals(2,fraction2.getNumerator());
        assertEquals(7,fraction2.getDenominator());
    }

    @Test
    void plus() {
        FractionImpl fraction1 = new FractionImpl(1,2);
        FractionImpl fraction2 = new FractionImpl(1,2);
        Fraction result = fraction1.plus(fraction2);
        assertEquals(1,result.getNumerator());
        assertEquals(1,result.getDenominator());

        FractionImpl fraction3 = new FractionImpl(3,4);
        FractionImpl fraction4 = new FractionImpl(7,8);
        Fraction result1 = fraction3.plus(fraction4);
        assertEquals(13,result1.getNumerator());
        assertEquals(8,result1.getDenominator());

        FractionImpl fraction5 = new FractionImpl(0,4);
        FractionImpl fraction6 = new FractionImpl(0,8);
        Fraction result3 = fraction5.plus(fraction6);
        assertEquals(0,result3.getNumerator());
        assertEquals(1,result3.getDenominator());

        FractionImpl fraction7 = new FractionImpl(1,4);
        FractionImpl fraction8 = new FractionImpl(-3,4);
        Fraction result4 = fraction7.plus(fraction8);
        assertEquals(1,result4.getNumerator());
        assertEquals(-2,result4.getDenominator());

    }
}