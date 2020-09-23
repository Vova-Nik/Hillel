package com.nikolenko.homeworks.homework_06;

public class FractionNumber {
    private  int numerator;        //keeps original values
    private  int denominator;

    public FractionNumber() {
        numerator = 0;
        denominator = 1;
    }

    public FractionNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

     public FractionNumber plus(FractionNumber fn) {
        int sumdNm = fn.denominator * this.denominator;
        int sumNm = this.numerator * fn.denominator + fn.numerator * this.denominator;
        return new FractionNumber(sumNm, sumdNm);
    }

    public FractionNumber minus(FractionNumber fn) {
        int sumdNm = fn.denominator * this.denominator;
        int sumNm = this.numerator * fn.denominator - fn.numerator * this.denominator;
        return new FractionNumber(sumNm, sumdNm);
    }

    public FractionNumber multiply(FractionNumber fn) {
        return this;
    }

    public FractionNumber divide(FractionNumber fn) {
        return this;
    }

    public String getValue() {
        if (denominator == 0) {
            return "Dividing by zerro error";
        }
        double dd = (double) numerator / denominator;
        return String.valueOf(dd);
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

    private void normalize() {
        int gCD = gcd(numerator, denominator);
        numerator = numerator / gCD;
        denominator = denominator / gCD;
    }

    private int gcd(int a, int b) {
        while (a != 0 && b != 0) // until either one of them is 0
        {
            int c = b;
            b = a % b;
            a = c;
        }
        return a + b; // either one is 0, so return the non-zero value
    }
}
