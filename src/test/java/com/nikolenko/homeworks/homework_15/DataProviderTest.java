package com.nikolenko.homeworks.homework_15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DataProviderTest {
    DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        dataProvider = new DataProvider();
    }

    @Test
    void addFile() {
        dataProvider.addFile("src\\test\\java\\com\\nikolenko\\homeworks\\homework_15\\list.csv");
        System.out.println(dataProvider);
        assertEquals(14,dataProvider.getSize());
        dataProvider.addString("John,Bush,24,186,69,finnn@live.com");
        assertEquals(15,dataProvider.getSize());
    }

    @Test
    void provide() {
        dataProvider.addFile("src\\test\\java\\com\\nikolenko\\homeworks\\homework_15\\list.csv");
        System.out.println(dataProvider);
        assertEquals(14,dataProvider.getSize());
        Set<Person> setOfPerson1 =  dataProvider.provide();
        assertEquals(14,setOfPerson1.size());
        dataProvider.addString("Eugene,Berezhnyi,32,170,81,berezhnoy87@gmail.com");
        Set<Person> setOfPerson2 =  dataProvider.provide();
        assertEquals(15,dataProvider.getSize());
        assertEquals(14,setOfPerson2.size());
    }

    @Test
    void testToString() {

    }
}