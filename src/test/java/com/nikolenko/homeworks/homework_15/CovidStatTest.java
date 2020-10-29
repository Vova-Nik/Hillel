package com.nikolenko.homeworks.homework_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CovidStatTest {
    CovidStat covidStat;
    DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        dataProvider = new DataProvider();
        dataProvider.addString("Eugene,Berezhnyi,32,170,81,berezhnoy87@gmail.com");
        dataProvider.addString("Mike,Tyson,54,178,81,iron.mike@gmail.com");
        dataProvider.addString("Mike,Naumenko,36,150,70,mike@mail.ru");
        dataProvider.addString("Volodymyr,Zelensky,42,165,78,zelensky@ukr.com");
        dataProvider.addString("Vlad,First,42,165,78,first@gmail.com");
        dataProvider.addString("Vlad,Second,42,165,78,second@gmail.com");
        dataProvider.addString("Vlad,Third,42,165,78,vhird@gmail.com");
        dataProvider.addString("John,Smith,22,166,68,smith@live.com");
        dataProvider.addString("Johny,Rust,23,176,78,abrek@live.com");
        dataProvider.addString("John,Bush,24,186,69,finnn@live.com");
        dataProvider.addString("Eugene,Comma,12,170,81,comma@gmail.com");
        dataProvider.addString("Mikle,Pyson,55,188,81,ironmike@gmail.com");
        dataProvider.addString(" Mishel,boui,26,160,70,boui@mail.ru");
        dataProvider.addString("George,Tyson,44,172,81,silver.mike@gmail.com");
        covidStat = new CovidStat(dataProvider.provide());
    }

    @Test
    void getMostPopularName() {
        String mostPopularName = covidStat.getMostPopularName();
        System.out.println("Most popular name 1st pass = " + mostPopularName);
        assertEquals("Vlad", mostPopularName);

        dataProvider.addString("Mike,regan,42,165,78,regan@ukr.com");
        covidStat = new CovidStat(dataProvider.provide());
        mostPopularName = covidStat.getMostPopularName();
        System.out.println("Most popular name 2nd pass = " + mostPopularName);
        assertEquals("Mike", mostPopularName);

        dataProvider.addString("Volodymyr,Zeleny,42,165,78,zeleny@ukr.com");
        dataProvider.addString("Volodymyr,Bely,42,165,78,Bely@ukr.com");
        dataProvider.addString("Volodymyr,Charny,42,165,78,Charny@ukr.com");
        covidStat = new CovidStat(dataProvider.provide());

        mostPopularName = covidStat.getMostPopularName();
        System.out.println("Most popular name 3rd pass = " + mostPopularName);
        assertEquals("Volodymyr", mostPopularName);
    }


    @Test
    void getMostPopularSurname() {
        String mostPopularSurename = covidStat.getMostPopularSurname();
        System.out.println("Most popular surname 1st pass = " + mostPopularSurename);
        assertEquals("Tyson", mostPopularSurename);
        dataProvider.addString("Mike,regan,42,165,78,regan@ukr.com");
        dataProvider.addString("Hike,regan,43,165,78,regan@ukr.com");
        dataProvider.addString("Bike,regan,44,165,78,regan@ukr.com");

        covidStat = new CovidStat(dataProvider.provide());
        mostPopularSurename = covidStat.getMostPopularSurname();
        System.out.println("Most popular surname 2nd pass = " + mostPopularSurename);
        assertEquals("regan", mostPopularSurename);
    }

    @Test
    void getMostPopularDomain() {
        String mostPopularDomain = covidStat.getMostPopularDomain();
        System.out.println("Most popular domain 1st pass = " + mostPopularDomain);
        assertEquals("gmail.com", mostPopularDomain);
    }

    @Test
    void getAverageAge() {
        System.out.println("Average age is " + covidStat.getAverageAge());
        assertEquals(35, covidStat.getAverageAge());
    }

    @Test
    void getAverageHeight() {
        System.out.println("Average height is " + covidStat.getAverageHeight());
        assertEquals(170, covidStat.getAverageHeight());
    }

    @Test
    void getAverageWeight() {
        System.out.println("Average weight is " + covidStat.getAverageWeight());
        assertEquals(77, covidStat.getAverageWeight());
    }
}