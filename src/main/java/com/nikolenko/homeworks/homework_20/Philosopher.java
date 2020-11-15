package com.nikolenko.homeworks.homework_20;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Philosopher implements Runnable {
    private final String name;
    private Fork leftFork;
    private Fork rightFork;
    private boolean sleeping;
    private int cycleCounter;

    Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        sleeping = true;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public int getCycleCounter() {
        return cycleCounter;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        sleeping = false;
        boolean leftTaken = false;
        boolean rightTaken = false;
        log.info(name + " arise");
        longRndDelay();
        leftFork.take(this);
        shortRndDelay();
        rightFork.take(this);
        log.info(name + " is eating");
        eat();
        leftFork.put();
        shortRndDelay();
        rightFork.put();
        cycleCounter++;
        sleeping = true;
        log.info(name + " went sleep");
    }

    private void eat() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void shortRndDelay() {
        Random r = new Random();
        int delay = r.nextInt(16);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void longRndDelay() {
        Random r = new Random();
        int delay = r.nextInt(144) + 16;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
