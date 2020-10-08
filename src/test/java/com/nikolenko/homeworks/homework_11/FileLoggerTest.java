package com.nikolenko.homeworks.homework_11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class FileLoggerTest {
   @BeforeEach
    void deleteOldFile() throws SecurityException {
        File file = new File("log.txt");
        if (file.exists()) {
            if (!file.delete()) {
                System.out.println("FileLoggerTest. Unable old file");
            }
        }
    }

    @Test
    void testException(){
        try {
            FileLogger fileLogger = new FileLogger(LogLevel.DEBUG, "\\safsafdsafsd\\log.txt");
        }catch(IOException e){
            assertTrue(e.toString().contains("cannot find the path"));
        }
    }

    @Test
    void logAll() {

        try (FileLogger fileLogger = new FileLogger(LogLevel.ALL, "log.txt")) {
            fileLogger.log("FileLogger ALL", LogLevel.ALL);
            fileLogger.log("FileLogger TRACE", LogLevel.TRACE);
            fileLogger.log("FileLogger DEBUG", LogLevel.DEBUG);
            fileLogger.log("FileLogger INFO", LogLevel.INFO);
            fileLogger.log("FileLogger WARN", LogLevel.WARN);
            fileLogger.log("FileLogger ERROR", LogLevel.ERROR);
            fileLogger.log("FileLogger FATAL", LogLevel.FATAL);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        try (FileReader fileRider = new FileReader("log.txt")) {
            Scanner scanner = new Scanner(fileRider);
            assertTrue(scanner.nextLine().contains("FileLogger ALL"));
            assertTrue(scanner.nextLine().contains("FileLogger TRACE"));
            assertTrue(scanner.nextLine().contains("FileLogger DEBUG"));
            assertTrue(scanner.nextLine().contains("FileLogger INFO"));
            assertTrue(scanner.nextLine().contains("FileLogger WARN"));
            assertTrue(scanner.nextLine().contains("FileLogger ERROR"));
            assertTrue(scanner.nextLine().contains("FileLogger FATAL"));
            assertFalse(scanner.hasNext());
        } catch (IOException e) {
            System.out.println("File reading error. " + e.toString());
        }
    }

    @Test
    void logDEBUG() {
        FileLogger fileLogger = null;
        try {
            fileLogger = new FileLogger(LogLevel.DEBUG, "log.txt");
        } catch (IOException e) {
            System.out.println("File creating error. " + e.toString());
        }
        if (fileLogger != null) {
            fileLogger.log("FileLogger ALL", LogLevel.ALL);
            fileLogger.log("FileLogger TRACE", LogLevel.TRACE);
            fileLogger.log("FileLogger DEBUG", LogLevel.DEBUG);
            fileLogger.log("FileLogger INFO", LogLevel.INFO);
            fileLogger.log("FileLogger WARN", LogLevel.WARN);
            fileLogger.log("FileLogger ERROR", LogLevel.ERROR);
            fileLogger.log("FileLogger FATAL", LogLevel.FATAL);

            fileLogger.close();


            try (FileReader fileRider = new FileReader("log.txt")) {
                Scanner scanner = new Scanner(fileRider);
                String first = scanner.nextLine();
                assertFalse(first.contains("FileLogger ALL"));
                assertFalse(first.contains("FileLogger TRACE"));
                assertTrue(first.contains("FileLogger DEBUG"));

                assertTrue(scanner.nextLine().contains("FileLogger INFO"));
                assertTrue(scanner.nextLine().contains("FileLogger WARN"));
                assertTrue(scanner.nextLine().contains("FileLogger ERROR"));
                assertTrue(scanner.nextLine().contains("FileLogger FATAL"));
                assertFalse(scanner.hasNext());

            } catch (IOException e) {
                System.out.println("File reading error. " + e.toString());
            }
        }
    }
}