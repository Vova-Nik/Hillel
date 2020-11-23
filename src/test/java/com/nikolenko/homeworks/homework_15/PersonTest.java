package com.nikolenko.homeworks.homework_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
    void reflection() {
        Class c = null;
        try {
            c = Class.forName("com.nikolenko.homeworks.homework_15.Person");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        Constructor[] cons = c.getConstructors();
        printList("Constructors", cons);

        Annotation[] ann = c.getAnnotations();
        printList("Annotationss", ann);

        Method[] met = c.getMethods();
        printList("Methods", met);

        Field[] fields = c.getFields();
        printList("Fields", fields);
    }

    static void printList(String s, Object[] o) {
        System.out.println("*** " + s + " ***");
        for (Object value : o) System.out.println(value.toString());
    }

    @Test
    void printSomeNumber() {
        Class c = null;
        try {
            c = Class.forName("com.nikolenko.homeworks.homework_15.Person");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        Class[] cl = new Class[]{Double.TYPE, Double.TYPE};
        Method m = null;
        try {
            m = c.getMethod("printSomeNumber", cl);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        double val1 = 11.0;
        double val2 = 22.0;
        try {
            // m.invoke(null, new Object[]{val1, val2});
            m.invoke(null, val1, val2);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}