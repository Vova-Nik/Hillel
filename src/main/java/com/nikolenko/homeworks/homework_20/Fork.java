package com.nikolenko.homeworks.homework_20;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Fork {
    ReentrantLock lock = new ReentrantLock();
    Philosopher currentOwner;
    String name;
    public volatile boolean bysy = false;

    public Fork(String name) {
        this.name = name;
    }

    ReentrantLock getLocker() {
        return lock;
    }

    public void take(Philosopher owner) {
        lock.lock();
        currentOwner = owner;
        log.info("|||  " + name + " taken by " + currentOwner.getName());
    }

    public void put() {
        log.info("||| " + currentOwner.getName() + " put  " + name);
        lock.unlock();
    }
}
