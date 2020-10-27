package com.nikolenko.homeworks.homework_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CovidStatTest {
    CovidStat covidStat;
    DataProvider dataProvider;
    @BeforeEach
    void setUp(){
        dataProvider = new DataProvider();
        dataProvider.addFile("src\\test\\java\\com\\nikolenko\\homeworks\\homework_15\\list.csv");
        covidStat = new CovidStat(dataProvider.provide());
    }

    @Test
    void getMostPopularName() {
        String mostPopularName = covidStat.getMostPopularName();
        System.out.println("Most popular name 1st pass = " + mostPopularName);
        assertEquals("Vlad",mostPopularName);

        dataProvider.addString("Mike,regan,42,165,78,regan@ukr.com");
        covidStat = new CovidStat(dataProvider.provide());
        mostPopularName = covidStat.getMostPopularName();
        System.out.println("Most popular name 2nd pass = " + mostPopularName);
        assertEquals("Mike",mostPopularName);

        dataProvider.addString("Volodymyr,Zeleny,42,165,78,zeleny@ukr.com");
        dataProvider.addString("Volodymyr,Bely,42,165,78,Bely@ukr.com");
        dataProvider.addString("Volodymyr,Charny,42,165,78,Charny@ukr.com");
        covidStat = new CovidStat(dataProvider.provide());

        mostPopularName = covidStat.getMostPopularName();
        System.out.println("Most popular name 3rd pass = " + mostPopularName);
        assertEquals("Volodymyr",mostPopularName);
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
        assertEquals(35,covidStat.getAverageAge());
    }

    @Test
    void getAverageHeight() {
        System.out.println("Average height is " + covidStat.getAverageHeight());
        assertEquals(170,covidStat.getAverageHeight());
    }

    @Test
    void getAverageWeight() {
        System.out.println("Average weight is " + covidStat.getAverageWeight());
        assertEquals(77,covidStat.getAverageWeight());
    }
}