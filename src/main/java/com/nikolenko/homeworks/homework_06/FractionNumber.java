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


public class FractionNumber {
    private final int numerator;
    private final int denominator;

    public FractionNumber() {
        numerator = 1;
        denominator = 2;
    }

    public FractionNumber(int numerator, int denominator) {
        Fraction fr = normalize(numerator, denominator);
        this.numerator = fr.up;
        this.denominator = fr.dn;
    }

    /*********************** plus *******************************/
    public FractionNumber plus(FractionNumber fn) {
        int sumdNm = fn.denominator * this.denominator;
        int sumNm = this.numerator * fn.denominator + fn.numerator * this.denominator;
        return new FractionNumber(sumNm, sumdNm);
    }

    /*********************** minus *******************************/
    public FractionNumber minus(FractionNumber fn) {
        int sumdNm = fn.denominator * this.denominator;
        int sumNm = this.numerator * fn.denominator - fn.numerator * this.denominator;
        return new FractionNumber(sumNm, sumdNm);
    }

    /*********************** multiply *******************************/
    public FractionNumber multiply(FractionNumber fn) {
        return new FractionNumber(this.numerator * fn.numerator, this.denominator * fn.denominator);
    }

    /*********************** divide *******************************/
    public FractionNumber divide(FractionNumber fn) {
        FractionNumber inverted = new FractionNumber(fn.denominator, fn.numerator);
        return multiply(inverted);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double getValue() {
        return (double)numerator / (double)denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FractionNumber that = (FractionNumber) o;
        return numerator == that.numerator &&
                denominator == that.denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

/******************************** Srvice *********************************
********************************** reduces fraction ***********************/
    private Fraction normalize(int nm, int dn) {
        if (dn == 0) {
            dn = 1;
            if (nm >= 0) {
                nm = Integer.MAX_VALUE;
            }
            if (nm < 0) {
                nm = Integer.MIN_VALUE;
            }
        }
        int a = nm;
        int b = dn;
        while (a != 0 && b != 0)
        {
            int c = b;
            b = a % b;
            a = c;
        }
        int gcd = a + b;
        nm = nm / gcd;
        dn = dn / gcd;

        return new Fraction(nm, dn);
    }

    /************** to make normalize method "pure function" ****************/

    private static class Fraction {
        private int up;
        private int dn;

        Fraction(int up, int dn) {
            this.up = up;
            this.dn = dn;
        }
    }
}
