package com.nikolenko.homeworks.homework_21;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class Average {

    private final int[] arrayToCalculate;

    Average(int[] arr) {
        arrayToCalculate = arr;
    }

    @SneakyThrows
    public double proceed() {
        if (arrayToCalculate.length % 4 != 0) {
            throw new IllegalArgumentException("Bad Array length");
        }
        int k = arrayToCalculate.length / 4;
        CountDownLatch countDownLatch = new CountDownLatch(4);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Double> f1 = executor.submit(new TaskRunner(arrayToCalculate, 0, k,countDownLatch));
        Future<Double> f2 = executor.submit(new TaskRunner(arrayToCalculate, k, 2 * k,countDownLatch));
        Future<Double> f3 = executor.submit(new TaskRunner(arrayToCalculate, 2 * k, 3 * k,countDownLatch));
        Future<Double> f4 = executor.submit(new TaskRunner(arrayToCalculate, 3 * k, arrayToCalculate.length,countDownLatch));
        countDownLatch.await();
        return ((f1.get() + f2.get() + f3.get() + f4.get()) / 4);
    }
}

class TaskRunner implements Callable<Double> {
    CountDownLatch countDownLatch;
    int[] toProcess;
    int beginIndex;
    int endIndex;

    TaskRunner(int[] toProcess, int beg, int end, CountDownLatch cdl) {
        countDownLatch = cdl;
        this.toProcess = toProcess;
        beginIndex = beg;
        endIndex = end;
    }

    @Override
    public Double call(){
        double avr = 0;
        for (int i = beginIndex; i < endIndex; i++) {
            avr += toProcess[i];
        }
        countDownLatch.countDown();
        return avr / (toProcess.length/4);
    }
}