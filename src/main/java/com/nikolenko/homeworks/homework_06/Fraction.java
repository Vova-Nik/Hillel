package com.nikolenko.homeworks.homework_06;

public interface Fraction {
    Fraction plus(Fraction other);
    Fraction minus(Fraction other);
    Fraction multiply(Fraction other);
    Fraction divide(Fraction other);
    int getNumerator();
    int getDenominator();
}
