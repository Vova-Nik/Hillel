package com.nikolenko.homeworks.homework_18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person1;
    Person person2;
    Person person3;

    @BeforeEach
    void setUp() {
        person1 = Person.builder().name("Mike").surname("Tyson").age(54).height(178).weight(81).mail("iron.mike@gmail.com").build();
        person2 = Person.builder().name("Mike").surname("Tyson").age(54).height(178).weight(81).mail("iron.mike@gmail.com").build();
        person3 = Person.builder().name("Nik").surname("Tyson").age(34).height(178).weight(81).mail("iron.mike@gmail.com").build();
    }

    @Test
    void testToString() {
        System.out.println(person1);
        assertTrue(person1.toString().contains("iron.mike@gmail.com"));
    }

    @Test
    void getName() {
        assertEquals("Mike", person1.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Tyson", person1.getSurname());
    }

    @Test
    void getAge() {
        assertEquals(54, person1.getAge());
    }

    @Test
    void getWeight() {
        assertEquals(81, person1.getWeight());
    }

    @Test
    void getHeight() {
        assertEquals(178, person1.getHeight());
    }

    @Test
    void getMail() {
        assertEquals("iron.mike@gmail.com", person1.getMail());
    }

    @Test
    void getDomain() {
        assertEquals("gmail.com", person1.getDomain());
    }

    @Test
    void testEquals() {
        assertEquals(person1, person2);
        assertNotEquals(person1, person3);
    }

    @Test
    void testSerialize() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(person1);
            objectOutputStream.writeObject(person3);
        } catch (IOException e) {
            fail("ByteArrayOutputStream in Person class serialization test");
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        Person pers1=null, pers3=null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            try {
                 pers1 = (Person) objectInputStream.readObject();
                 pers3 = (Person) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                fail("ClassNotFoundException in Person class serialization test");
            }
        } catch (IOException e) {
            fail("ByteArrayInputStream in Person class serialization test");
        }
        assertEquals(person1, pers1);
        assertNotEquals(pers1, pers3);
    }
}