package com.nikolenko.homeworks.homework_14;

public class Stat<T extends Number> {
    private final T[] array;

    public Stat(T[] v) {
        array = v;
    }

    public void printData() {
        System.out.println(array.getClass());
        for (T item : array) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }

    public double average() {
        double result = 0;
        for (T item : array) {
            result = result + item.doubleValue();
        }
        return result / array.length;
    }

    public boolean isSameAverage(Stat<?> other) {
        return this.average() == other.average();
    }
}
