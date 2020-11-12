package com.nikolenko.homeworks.homework_18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProviderFactoryTest {
    private final String CSV_FILENAME = "covid.csv";
    private final String DAT_FILENAME = "covid.dat";
    List<Person> personListHard;

    @BeforeEach
    void setUp() throws IOException {

        if(new File(CSV_FILENAME).delete()){
            int a = 0;
        }

        String file =
                "Mike,Tyson,54,178,81,iron.mike@gmail.com\n" +
                        "Jack,Tyson,54,178,82,iron.jack@gmail.com\n" +
                        "Nik,Tyson,34,178,83,iron.nik@gmail.com\n";

        BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILENAME));
        writer.write(file);
        writer.close();

        if(new File(DAT_FILENAME).delete()){
            int a = 0;
        }

        Person person1 = Person.builder().name("Mike").surname("Tyson").age(54).height(178).weight(81).mail("iron.mike@gmail.com").build();
        Person person2 = Person.builder().name("Jack").surname("Tyson").age(54).height(178).weight(82).mail("iron.jack@gmail.com").build();
        Person person3 = Person.builder().name("Nik").surname("Tyson").age(34).height(178).weight(83).mail("iron.nik@gmail.com").build();
        personListHard = new ArrayList<>();
        personListHard.add(person1);
        personListHard.add(person2);
        personListHard.add(person3);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DAT_FILENAME))) {
            objectOutputStream.writeObject(personListHard);
        } catch (IOException e) {
            fail("IOException in serializeTest" + e.toString());
        }
    }

    @Test
    void getInstance() {
        DataProviderFactory factory = DataProviderFactory.getInstance();
        if (factory == null) {
            fail("Factory creation error");
        }
        DataProviderFactory factory1 = DataProviderFactory.getInstance();
        assertEquals(factory, factory1);
    }

    @Test
    void createCSV() {
        DataProviderFactory factory = DataProviderFactory.getInstance();
        Object object = null;
        try {
            object = factory.create(CSV_FILENAME);
        } catch (DataProviderFactoryException e) {
            fail(e.toString());
        }
        assertTrue(object.getClass().getName().contains("CSVDataProvider"));
        CSVDataProvider csvDataProvider = (CSVDataProvider) object;
        List<Person> personList = csvDataProvider.provide();
        assertEquals(3, personList.size());
        assertEquals(personListHard, personList);
    }

    @Test
    void createDAT() {
        DataProviderFactory factory = DataProviderFactory.getInstance();

        Object object = null;
        try {
            object = factory.create(DAT_FILENAME);
        } catch (DataProviderFactoryException e) {
            fail(e.toString());
        }
        assertTrue(object.getClass().getName().contains("DatDataProvider"));
        DatDataProvider datDataProvider = (DatDataProvider) object;
        List<Person> personList = datDataProvider.provide();

        assertEquals(3, personList.size());
        assertEquals(personListHard, personList);
    }

    @Test
    void incorrectCall() {
        DataProviderFactory factory = DataProviderFactory.getInstance();
        try {
            CSVDataProvider csvDataProvider = (CSVDataProvider) factory.create("");
        } catch (DataProviderFactoryException e) {
            assertTrue(e.toString().contains("DataProviderFactoryException Occurred: "));
            assertTrue(e.toString().contains("Bad file name"));
        }
        try {
            CSVDataProvider csvDataProvider = (CSVDataProvider) factory.create("file.txt");
        } catch (DataProviderFactoryException e) {
            assertTrue(e.toString().contains("DataProviderFactoryException Occurred: "));
            assertTrue(e.toString().contains("Bad file type"));
        }
    }
}