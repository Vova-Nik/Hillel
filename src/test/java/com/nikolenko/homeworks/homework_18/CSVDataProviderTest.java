package com.nikolenko.homeworks.homework_18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVDataProviderTest {
    private final String CSV_FILENAME = "covid.csv";
    private final String DAT_FILENAME = "covid.dat";
    CSVDataProvider dataProvider;

    @BeforeEach
    void setUp() throws IOException {
        dataProvider = new CSVDataProvider();
        String csvFile = "Eugene,Berezhnyi,32,170,81,berezhnoy87@gmail.com\n" +
                "Mike,Tyson,54,178,81,iron.mike@gmail.com\n" +
                "Volodymyr,Zelensky,42,165,78,zelensky@ukr.com\n" +
                "George,Tyson,44,172,81,silver.mike@gmail.com\n";
        BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILENAME));
        writer.write(csvFile);
        writer.close();
    }

    @Test
    void readFile() {
        if (!dataProvider.readFile(CSV_FILENAME)) {
            fail("CSVDataProvider can not read file");
        }
        assertEquals(4, dataProvider.getSize());
    }

    @Test
    void provide() {
        dataProvider.readFile(CSV_FILENAME);
        List<Person> listOfPerson1 = dataProvider.provide();
        assertEquals(4, listOfPerson1.size());
        Person person1 = Person.builder().name("Mike").surname("Tyson").age(54).height(178).weight(81).mail("iron.mike@gmail.com").build();
        assertTrue(listOfPerson1.contains(person1));
    }

    @Test
    void saveToFile() {
        dataProvider.readFile(CSV_FILENAME);
        System.out.println(dataProvider);
        if (!dataProvider.saveToFile(DAT_FILENAME)) {
            fail("CSVDataProvider can not save file");
        }

        List<Person> personList1 = dataProvider.provide();
        List<Person> personList2 = new ArrayList<>();
        Object object = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DAT_FILENAME))) {
            object =  objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            fail("serializeTest ObjectInputStream ClassNotFoundException");
        } catch (IOException e) {
            fail("DataProvider error. " + e);
        }

        if(object.getClass().toString().equals("class java.util.ArrayList") ) {
            personList2 = (ArrayList<Person>) object;
        }
        assertEquals(personList1.size(), personList2.size());
        assertTrue(personList1.contains(personList2.get(1)));
        assertEquals(personList1, personList2);
    }
}