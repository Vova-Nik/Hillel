package com.nikolenko.homeworks.homework_10;

import com.nikolenko.homeworks.homework_06.Fraction;

public interface Sellable {

    Sellable getCopy();
    @Override
    boolean equals(Object o);
    @Override
    int hashCode();
    @Override
    String toString();
}
