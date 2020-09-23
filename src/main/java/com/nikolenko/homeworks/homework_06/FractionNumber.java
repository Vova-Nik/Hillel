package com.nikolenko.homeworks.homework_06;

import java.util.Objects;

public class FractionNumber {
    private final int numerator;
    private final int denominator;

    private int inumerator;
    private int idenominator;

    public FractionNumber() {
        numerator = 0;
        denominator = 1;
    }

    public FractionNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

    private void normalize() {
        inumerator = numerator;
        idenominator = denominator;
        if (idenominator == 0) {
            idenominator = 1;
        }
    }


    public FractionNumber plus(FractionNumber fn) {
        return this;
    }

    public FractionNumber minus(FractionNumber fn) {
        return this;
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

    public String toPrintg() {
        return numerator + "/" + denominator + "   " + inumerator + "/" + idenominator;
    }
}
