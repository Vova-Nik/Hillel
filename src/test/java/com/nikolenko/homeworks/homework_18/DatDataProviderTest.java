package com.nikolenko.homeworks.homework_18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatDataProviderTest {
    private final String DAT_FILENAME = "covid.dat";
    List<Person> personListHard;

    @BeforeEach
    void setUp() {
        if (new File(DAT_FILENAME).delete()) {
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
    void readFile() {
        DatDataProvider dataProvider = new DatDataProvider();
        if (!dataProvider.readFile(DAT_FILENAME)) {
            fail("DatDataProvider can not read");
        }
        List<Person> personListFile = dataProvider.provide();
        assertEquals(3, dataProvider.getSize());
        assertEquals(personListHard, personListFile);
    }

    @Test
    void saveToFile() {
        DatDataProvider dataProvider = new DatDataProvider();
        dataProvider.readFile(DAT_FILENAME);
        if (new File("DAT_FILENAME").delete()) {
            int a = 0;
        }
        if (!dataProvider.saveToFile(DAT_FILENAME)) {
            fail("Can not save to file");
        }
        List<Person> personListFile = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DAT_FILENAME))) {
            personListFile = (ArrayList<Person>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            fail("serializeTest ObjectInputStream ClassNotFoundException");
        } catch (IOException e) {
            fail("DataProvider error. " + e);
        }
        assertEquals(personListHard.size(), personListFile.size());
        assertTrue(personListHard.contains(personListFile.get(1)));
        assertEquals(personListHard, personListFile);
    }
}
