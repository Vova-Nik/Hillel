package com.nikolenko.homeworks.homework_11;

import java.io.PrintWriter;

public class ConsoleLogger extends Logger {
    private final LogLevel logLevel;
    private Logger logger;

    ConsoleLogger(LogLevel logLevel)  {
        super(new PrintWriter(System.out));
        this.logLevel = logLevel;
    }

    void log(String toLog, LogLevel loglevel) {
        if (loglevel.getLevel() >= this.logLevel.getLevel()) {
            try {
                super.log(toLog);
            } catch (LoggerException lge) {
                System.out.println(lge.toString());
            }
        }
    }

    public void close() {
        try {
            super.close();
        } catch (LoggerException lge) {
            System.out.println(lge.toString());
        }
    }
}
