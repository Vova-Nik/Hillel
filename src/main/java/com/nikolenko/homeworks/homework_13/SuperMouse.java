package com.nikolenko.homeworks.homework_13;

import lombok.Value;

@Value
public class SuperMouse implements Comparable<SuperMouse> {
    String name;
    int energValue;

    @Override
    public int compareTo(SuperMouse other) {
        return this.energValue - other.energValue;
    }
}
