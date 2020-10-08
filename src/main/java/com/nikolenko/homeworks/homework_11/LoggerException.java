package com.nikolenko.homeworks.homework_11;

public class LoggerException extends Exception {
    String error;

    LoggerException(String error) {
        this.error = error;
    }

    public String toString() {
        return ("LoggerException =  " + error);
    }
}
