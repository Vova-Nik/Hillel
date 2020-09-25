package com.nikolenko.homeworks.homework_06;

/**
 * FractionNumber Class
 *
 * Holds reduced fraction (not 8/4 but 1/2)
 * numerator and denominator integers
 * if passed to constructor denominator = 0, fraction becomes max/min integer value instead of infinity
 * (1/0 = 2147483647/1, -1/0 = -2147483648/1)
 *
 * Constructors
 * public FractionNumber() (1/2)
 * public FractionNumber(int numerator, int denominator);
 *
 * Methods
 * public FractionNumber plus(FractionNumber fn);
 * public FractionNumber minus(FractionNumber fn);
 * public FractionNumber multiply(FractionNumber fn);
 * public FractionNumber divide(FractionNumber fn);
 * public double getValue();
 *
 * Overrides
 * public boolean equals(Object o);
 * public String toString();
 *
 */


public class FractionImpl implements Fraction {
    private final int numerator;
    private final int denominator;

    public FractionImpl(int numerator, int denominator) {

        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
            return;
        }
        int gcd = greatestCommonDivisor(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    /*********************** plus *******************************/
    @Override
    public Fraction plus(Fraction other) {
        int sumdNm = other.getDenominator() * this.getDenominator();
        int sumNm = this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator();
        return new FractionImpl(sumNm, sumdNm);
    }

    /*********************** minus *******************************/
    @Override
    public Fraction minus(Fraction other) {
//        int sumdNm = fn.denominator * this.denominator;
//        int sumNm = this.numerator * fn.denominator - fn.numerator * this.denominator;
//        return new FractionNumber(sumNm, sumdNm);
        return null;
    }

    /*********************** multiply *******************************/
    @Override
    public Fraction multiply(Fraction other) {
//        return new FractionNumber(this.numerator * fn.numerator, this.denominator * fn.denominator);
        return null;
    }

    /*********************** divide *******************************/
    @Override
    public Fraction divide(Fraction other) {
//        FractionNumber inverted = new FractionNumber(fn.denominator, fn.numerator);
//        return multiply(inverted);
        return null;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
//
//    public double getValue() {
//        return (double)numerator / (double)denominator;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction that = (Fraction) o;
        return numerator == that.getNumerator() &&
                denominator == that.getDenominator();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

/* greatest common divisor  */
    private int greatestCommonDivisor(int a, int b) {

        while (a != 0 && b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }
}


