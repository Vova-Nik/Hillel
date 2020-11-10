package com.nikolenko.homeworks.homework_19;

public class Average {
    public static double oneThreadAverage(int[] arrayToCalculate) {
        double sum = 0;
        for (int next : arrayToCalculate) {
            sum = sum + next;
        }
        return sum / arrayToCalculate.length;
    }

    public static double multyThreadAverage(int[] arrayToCalculate) throws AverageInputDataException{
        if (arrayToCalculate.length % 4 != 0) {
            throw new AverageInputDataException("arrayToCalculate.length % 4 != 0");
        }
        AverageThread averageThread1 = new AverageThread(arrayToCalculate, 0, arrayToCalculate.length / 4);
        Thread thread1 = new Thread(averageThread1);
        thread1.start();
        AverageThread averageThread2 = new AverageThread(arrayToCalculate, arrayToCalculate.length / 4, arrayToCalculate.length / 2);
        Thread thread2 = new Thread(averageThread2);
        thread2.start();
        AverageThread averageThread3 = new AverageThread(arrayToCalculate, arrayToCalculate.length / 2, 3 * arrayToCalculate.length / 4);
        Thread thread3 = new Thread(averageThread3);
        thread3.start();
        AverageThread averageThread4 = new AverageThread(arrayToCalculate, 3 * arrayToCalculate.length / 4, arrayToCalculate.length);
        Thread thread4 = new Thread(averageThread4);
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new AverageInputDataException("Thread interrupted");
        }
        return (averageThread1.getResult() + averageThread2.getResult() + averageThread3.getResult() + averageThread4.getResult()) / 4;
    }
}

class AverageThread implements Runnable {
    private final int[] array;
    private double result;
    int first;
    int last;

    AverageThread(int[] arr, int first, int last) {
        this.array = arr;
        this.first = first;
        this.last = last;
    }

    @Override
    public void run() {
        double sum = 0;
        for (int i=first; i<last; i++) {
            sum = sum + array[i];
        }
        result = sum / (last - first);
    }
    public double getResult() {
        return result;
    }
}

 class AverageInputDataException extends Exception {

    public AverageInputDataException(String message) {
        super(message);
    }
}