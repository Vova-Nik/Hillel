package com.nikolenko.homeworks.homework_11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {
    @Test
    void logToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("log.txt");
        try (Logger logger = new Logger(fileWriter)) {
            logger.log("Created");
            logger.log("second");
            logger.log("third");
        } catch (LoggerException le) {
            System.out.println("LoggerException during writing to file.\n" + le.toString());
        }

        FileReader fileRider = new FileReader("log.txt");
        Scanner scanner = new Scanner(fileRider);
        assertTrue(scanner.nextLine().contains("INFO: Created"));
        assertTrue(scanner.nextLine().contains("second"));
        fileRider.close();
    }

    @Test
    void logToCons() {
        PrintWriter printWriter = new PrintWriter(System.out);
        Logger logger = new Logger(printWriter);
        try {
            logger.log("Created");
            logger.log("second");
            logger.log("third");
        } catch (LoggerException le) {
            System.out.println("LoggerException during writing to console.\n" + le.toString());
        }
        try {
            logger.close();
        } catch (LoggerException e) {
            System.out.println(e.toString());
        }
    }
}
