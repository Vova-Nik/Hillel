package com.nikolenko.homeworks.homework_12;

import lombok.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@Value
public class Cat {
    ArrayBlockingQueue<Mouse> stomach;

    public Cat() {
        stomach = new ArrayBlockingQueue<>(5);
    }

    public boolean eat(Mouse mouse) {
        return stomach.offer(mouse);
    }

    public void unEat() {
        stomach.poll();
    }

    public List<Mouse> drain() {
        List<Mouse> mouses = new ArrayList<>(stomach);
        stomach.clear();
        return mouses;
    }
}


