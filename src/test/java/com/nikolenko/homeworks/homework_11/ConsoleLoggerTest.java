package com.nikolenko.homeworks.homework_11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleLoggerTest {

    @Test
    void log() {
        ConsoleLogger  consoleLogger = new ConsoleLogger(LogLevel.ALL);
        assertNotNull(consoleLogger);
        consoleLogger.log("ConsoleLogger ALL", LogLevel.ALL);
        consoleLogger.log("ConsoleLogger TRACE", LogLevel.TRACE);
        consoleLogger.log("ConsoleLogger DEBUG", LogLevel.DEBUG);
        consoleLogger.log("ConsoleLogger INFO", LogLevel.INFO);
        consoleLogger.log("ConsoleLogger WARN", LogLevel.WARN);
        consoleLogger.log("ConsoleLogger ERROR", LogLevel.ERROR);
        consoleLogger.log("ConsoleLogger FATAL", LogLevel.FATAL);
        consoleLogger.close();
    }
    @Test
    void consoleLogDEBUG() {
        ConsoleLogger  consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
        assertNotNull(consoleLogger);
        consoleLogger.log("ConsoleLogger ALL", LogLevel.ALL);
        consoleLogger.log("ConsoleLogger TRACE", LogLevel.TRACE);
        consoleLogger.log("ConsoleLogger DEBUG", LogLevel.DEBUG);
        consoleLogger.log("ConsoleLogger INFO", LogLevel.INFO);
        consoleLogger.log("ConsoleLogger WARN", LogLevel.WARN);
        consoleLogger.log("ConsoleLogger ERROR", LogLevel.ERROR);
        consoleLogger.log("ConsoleLogger FATAL", LogLevel.FATAL);
        consoleLogger.close();
    }
}