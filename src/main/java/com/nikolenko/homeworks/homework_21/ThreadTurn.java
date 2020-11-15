package com.nikolenko.homeworks.homework_21;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ThreadTurn {

    public String proceed() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<String> f0 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_0", countDownLatch));
        Future<String> f1 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_1", countDownLatch));
        Future<String> f2 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_2", countDownLatch));
        Future<String> f3 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_3", countDownLatch));
        Future<String> f4 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_4", countDownLatch));
        Future<String> f5 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_5", countDownLatch));
        Future<String> f6 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_6", countDownLatch));
        Future<String> f7 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_7", countDownLatch));
        Future<String> f8 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_8", countDownLatch));
        Future<String> f9 = executor.submit(new ThreadTurnRunner("ThreadTurnRunner_9", countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        executor.shutdown();
        String result = "";
        try {
            result = '\n'
                    + f0.get() + '\n'
                    + f1.get() + '\n'
                    + f2.get() + '\n'
                    + f3.get() + '\n'
                    + f4.get() + '\n'
                    + f5.get() + '\n'
                    + f6.get() + '\n'
                    + f7.get() + '\n'
                    + f8.get() + '\n'
                    + f9.get() + '\n';
        } catch (InterruptedException | ExecutionException i) {
            log.error(i.getMessage());
        }
        return result;
    }
}

@Slf4j
class ThreadTurnRunner implements Callable<String> {
    CountDownLatch countDownLatch;
    String name;

    ThreadTurnRunner(String name, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.currentThread().setName(name);
        log.debug(name + " sleeps");
        Thread.sleep(10000);
        countDownLatch.countDown();
        log.debug(name + " finished");
        return Thread.currentThread().getName();
    }
}