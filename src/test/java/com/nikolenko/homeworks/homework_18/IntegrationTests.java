package com.nikolenko.homeworks.homework_18;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IntegrationTests {
    @Test
    void testPerson() {
        PersonTest personTest = new PersonTest();
        personTest.setUp();
        personTest.getAge();
        personTest.getDomain();
        personTest.getHeight();
        personTest.getMail();
        personTest.getName();
        personTest.getSurname();
        personTest.testEquals();
        personTest.testSerialize();
        personTest.testEquals();
        personTest.testToString();
    }

    @Test
    void testDataMaper() {
        DataMapperTest dataMapperTest = new DataMapperTest();
        dataMapperTest.setUp();
        dataMapperTest.mapString();
    }

    @Test
    void testDatDataProvider() {
        DatDataProviderTest datDataProviderTest = new DatDataProviderTest();
        datDataProviderTest.setUp();
        datDataProviderTest.readFile();
        datDataProviderTest.saveToFile();
    }

    @Test
    void testCSVDataProvider() throws IOException {
        CSVDataProviderTest cSVDataProviderTest = new CSVDataProviderTest();
        cSVDataProviderTest.setUp();
        cSVDataProviderTest.readFile();
        cSVDataProviderTest.saveToFile();
    }

    @Test
    void testDataProviderFactoryTest() throws IOException {
        DataProviderFactoryTest dataProviderFactoryTest = new DataProviderFactoryTest();
        dataProviderFactoryTest.setUp();
        dataProviderFactoryTest.createCSV();
        dataProviderFactoryTest.createDAT();
        dataProviderFactoryTest.getInstance();
        dataProviderFactoryTest.incorrectCall();
    }

    @AfterAll
    static void clear() throws IOException {
        Path path = Paths.get("covid.csv");
        Files.deleteIfExists(path);
        path = Paths.get("covid.dat");
        Files.deleteIfExists(path);
    }
}
