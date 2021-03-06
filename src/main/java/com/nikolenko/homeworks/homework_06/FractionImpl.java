package com.nikolenko.homeworks.homework_06;

/**
 * FractionImplClass
 * <p>
 * Holds reduced fraction (not 8/4 but 1/2)
 * numerator and denominator integers
 */


public class FractionImpl implements Fraction {
    private final int numerator;
    private final int denominator;

    public FractionImpl(int numerator, int denominator)  throws IllegalArgumentException{
        denominator = Math.abs(denominator);
        if(denominator == 0){
            throw new IllegalArgumentException("Dividing by zero in FractionImpl constructor");
        }
        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
            return;
        }
        int gcd = greatestCommonDivisor(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    @Override
    public Fraction plus(Fraction other) {
        int sumdNm = Math.abs(other.getDenominator() * this.getDenominator());
        int sumNm = this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator();
        return new FractionImpl(sumNm, sumdNm);
    }

    @Override
    public Fraction minus(Fraction other) {
        int sumdNm = other.getDenominator() * this.denominator;
        int sumNm = this.numerator * other.getDenominator() - other.getNumerator() * this.denominator;
        return new FractionImpl(sumNm, sumdNm);
    }

    @Override
    public Fraction multiply(Fraction other) {
        return new FractionImpl(this.numerator * other.getNumerator(), this.denominator * other.getDenominator());
    }

    @Override
    public Fraction divide(Fraction other) {
        int invNumerator = other.getDenominator();
        if (other.getNumerator() < 0) {
            invNumerator = -invNumerator;
        }
        FractionImpl inverted = new FractionImpl(invNumerator, other.getNumerator());
        return multiply(inverted);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction that = (Fraction) o;
        if (that.hashCode() != hashCode()) {
            return false;
        }
        return numerator == that.getNumerator() &&
                denominator == that.getDenominator();
    }

    @Override
    public int hashCode() {
        return (numerator << 16) + denominator;
    }

    @Override
    public String toString() {
       return numerator + "/" + denominator;
    }

    private int greatestCommonDivisor(int a, int b) {
        while (a != 0 && b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return Math.abs(a + b);
    }

}


