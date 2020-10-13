package com.nikolenko.homeworks.homework_11;

import lombok.EqualsAndHashCode;

public enum LogLevel {
    ALL(10),
    TRACE(20),
    DEBUG(30),
    INFO(40),
    WARN(50),
    ERROR(60),
    FATAL(100);

    private final int level;
    LogLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }
}
