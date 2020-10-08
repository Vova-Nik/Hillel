package com.nikolenko.homeworks.homework_11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends Logger {
    private final LogLevel logLevel;
    private Logger logger;

    FileLogger(LogLevel logLevel, String fileName)  throws IOException {
        super(new FileWriter(new File(fileName)));
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
