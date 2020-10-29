package com.nikolenko.homeworks.homework_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProviderTest {
    DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        dataProvider = new DataProvider();
    }

    @Test
    void addFile() {
        char fs = File.separatorChar;

        String inputFilePath = "src" + fs +
                "test" + fs +
                "java" + fs +
                "com" + fs +
                "nikolenko" + fs +
                "homeworks" + fs +
                "homework_15" + fs +
                "list.csv";

        dataProvider.addFile(inputFilePath);
        System.out.println(dataProvider);
        assertEquals(14,dataProvider.getSize());
        dataProvider.addString("John,Bush,24,186,69,finnn@live.com");
        assertEquals(15,dataProvider.getSize());
    }

    @Test
    void provide() {
        dataProvider.addFile("src/test/java/com/nikolenko/homeworks/homework_15/list.csv");
        System.out.println(dataProvider);
        assertEquals(14,dataProvider.getSize());
        List<Person> listOfPerson1 =  dataProvider.provide();
        assertEquals(14,listOfPerson1.size());
        dataProvider.addString("Eugene,Berezhnyi,32,170,81,berezhnoy87@gmail.com");
        List<Person> setOfPerson2 =  dataProvider.provide();
        assertEquals(15,dataProvider.getSize());
    }

}