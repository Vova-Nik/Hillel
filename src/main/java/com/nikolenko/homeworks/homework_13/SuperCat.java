package com.nikolenko.homeworks.homework_13;

import com.nikolenko.homeworks.homework_12.Mouse;
import lombok.Value;

import java.util.*;

@Value
public class SuperCat {
    int STOMACH_SIZE = 5;

    Queue<SuperMouse> stomach = new PriorityQueue<>(STOMACH_SIZE);

    public boolean eat(SuperMouse mouse) {
        if(stomach.size()>=5){
            return false;
        }
        return stomach.offer(mouse);
    }

    public SuperMouse unEat() {
        return stomach.poll();
    }

    public HashSet<SuperMouse> drain() {
        HashSet<SuperMouse> mouses = new HashSet<>(stomach);
        stomach.clear();
        return mouses;
    }
}

