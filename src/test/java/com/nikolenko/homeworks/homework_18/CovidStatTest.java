package com.nikolenko.homeworks.homework_18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CovidStatTest {
    private final String CSV_FILENAME = "covid.csv";
    CovidStat covidStat;
    CSVDataProvider dataProvider1;
    CSVDataProvider dataProvider2;
    String fileVladTysonGmail =
            "Eugene,Berezhnyi,32,170,81,berezhnoy87@gmail.com\n" +
                    "Mike,Tyson,54,178,81,iron.mike@gmail.com\n" +
                    "Mike,Naumenko,36,150,70,mike@mail.ru\n" +
                    "Volodymyr,Zelensky,42,165,78,zelensky@ukr.com\n" +
                    "Vlad,First,42,165,78,first@gmail.com\n" +
                    "Vlad,Second,42,165,78,second@gmail.com\n" +
                    "Vlad,Third,42,165,78,vhird@gmail.com\n" +
                    "John,Smith,22,166,68,smith@live.com\n" +
                    "Johny,Rust,23,176,78,abrek@live.com\n" +
                    "John,Bush,24,186,69,finnn@live.com\n" +
                    "Eugene,Comma,12,170,81,comma@gmail.com\n" +
                    "Mikle,Pyson,55,188,81,ironmike@gmail.com\n" +
                    "Mishel,boui,26,160,70,boui@mail.ru\n" +
                    "George,Tyson,44,172,81,silver.mike@gmail.com";

    String fileMikePysonLivecom =
            "Eugene,Berezhnyi,32,170,81,berezhnoy87@live.com\n" +
                    "Mike,Smith,54,178,81,iron.mike@live.com\n" +
                    "Mike,Naumenko,36,150,70,mike@mail.ru\n" +
                    "Volodymyr,Zelensky,42,165,78,zelensky@ukr.com\n" +
                    "Vlad,First,42,165,78,first@gmail.com\n" +
                    "Vlad,Second,42,165,78,second@live.com\n" +
                    "Vlad,Third,42,165,78,vhird@gmail.com\n" +
                    "John,Smith,22,166,68,smith@live.com\n" +
                    "Johny,Rust,23,176,78,abrek@live.com\n" +
                    "John,Bush,24,186,69,finnn@live.com\n" +
                    "Eugene,Klark,12,170,81,comma@gmail.com\n" +
                    "Mikle,Pyson,55,188,81,ironmike@gmail.com\n" +
                    "Mike,Pyson,55,180,81,ironbyke@live.com\n" +
                    "Mishel,boui,26,160,70,boui@mail.ru\n" +
                    "George,Tyson,44,172,81,silver.mike@glive.com";

    @BeforeEach
    void setUp() throws IOException {
        if (new File(CSV_FILENAME).delete()) {
            int a = 0;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILENAME));
        writer.write(fileVladTysonGmail);
        writer.close();
        dataProvider1 = new CSVDataProvider();
        dataProvider1.readFile(CSV_FILENAME);

        writer = new BufferedWriter(new FileWriter(CSV_FILENAME));
        writer.write(fileMikePysonLivecom);
        writer.close();
        dataProvider2 = new CSVDataProvider();
        dataProvider2.readFile(CSV_FILENAME);
    }

    @Test
    void getMostPopularName() {
        covidStat = new CovidStat(dataProvider1.provide());
        String mostPopularName = covidStat.getMostPopularName();
        System.out.println("Most popular name 1st pass = " + mostPopularName);
        assertEquals("Vlad", mostPopularName);

        covidStat = new CovidStat(dataProvider2.provide());
        mostPopularName = covidStat.getMostPopularName();
        System.out.println("Most popular name 2nd pass = " + mostPopularName);
        assertEquals("Mike", mostPopularName);
    }


    @Test
    void getMostPopularSurname() {
        covidStat = new CovidStat(dataProvider1.provide());
        String mostPopularSurename = covidStat.getMostPopularSurname();
        System.out.println("Most popular surname 1st pass = " + mostPopularSurename);
        assertEquals("Tyson", mostPopularSurename);

        covidStat = new CovidStat(dataProvider2.provide());
        mostPopularSurename = covidStat.getMostPopularSurname();
        System.out.println("Most popular surname 2nd pass = " + mostPopularSurename);
        assertEquals("Pyson", mostPopularSurename);
    }

    @Test
    void getMostPopularDomain() {
        covidStat = new CovidStat(dataProvider1.provide());
        String mostPopularDomain = covidStat.getMostPopularDomain();
        System.out.println("Most popular domain 1st pass = " + mostPopularDomain);
        assertEquals("gmail.com", mostPopularDomain);

        covidStat = new CovidStat(dataProvider2.provide());
        mostPopularDomain = covidStat.getMostPopularDomain();
        System.out.println("Most popular domain 1st pass = " + mostPopularDomain);
        assertEquals("live.com", mostPopularDomain);
    }

    @Test
    void getAverageAge() {
        covidStat = new CovidStat(dataProvider1.provide());
        System.out.println("Average age is " + covidStat.getAverageAge());
        assertEquals(35, covidStat.getAverageAge());
    }

    @Test
    void getAverageHeight() {
        covidStat = new CovidStat(dataProvider1.provide());
        System.out.println("Average height is " + covidStat.getAverageHeight());
        assertEquals(170, covidStat.getAverageHeight());
    }

    @Test
    void getAverageWeight() {
        covidStat = new CovidStat(dataProvider1.provide());
        System.out.println("Average weight is " + covidStat.getAverageWeight());
        assertEquals(77, covidStat.getAverageWeight());
    }
}