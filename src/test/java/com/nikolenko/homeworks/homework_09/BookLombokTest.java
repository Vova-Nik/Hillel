package com.nikolenko.homeworks.homework_09;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookLombokTest {

    static AuthorLombok twain;
    static AuthorLombok king;

    static BookLombok sowyer;
    static BookLombok sowyerTwin;
    static BookLombok insomnia;

    @BeforeAll
    static void setUp() {
        twain = new AuthorLombok("Mark", "Twain", new Date(1835, 10, 30));
        king = new AuthorLombok("Stewen", "King", new Date(1947, 8, 21));

        sowyer = new BookLombok(twain, new Date(2001, 3, 22), Genre.FAIRY_TALE, 22334455, "Tom Sowyer");
        sowyerTwin = new BookLombok(twain, new Date(2001, 3, 22), Genre.FAIRY_TALE, 22334455, "Tom Sowyer");
        insomnia = new BookLombok(king, new Date(2011, 3, 22), Genre.BELLETRE, 22334455, "Insomnia");
    }


    @Test
    void getAuthor() {
        assertEquals(sowyer.getAuthor().hashCode(), twain.hashCode());
    }

    @Test
    void getIssueDate() {
        Date date = sowyer.getIssueDate();
        assertEquals(2001, date.getYear());
        assertEquals(3, date.getMonth());
        assertEquals(22, date.getDate());
        date.setYear(1861);
        assertEquals(2001, sowyer.getIssueDate().getYear());
    }

    @Test
    void getGenre() {
        assertEquals(sowyer.getGenre().getTitle(), Genre.FAIRY_TALE.getTitle());
    }

    @Test
    void getIsbn() {
        assertEquals(sowyer.getIsbn(), 22334455);
    }

    @Test
    void getTitle() {
        assertEquals(sowyer.getTitle(), "Tom Sowyer");
    }

    @Test
    void testEquals() {
        assertTrue(sowyer.equals(sowyer));
        assertTrue(sowyer.equals(sowyerTwin));
        assertFalse(sowyer.equals(insomnia));
    }

    @Test
    void testHashCode() {
        assertEquals(sowyer.hashCode(), sowyer.hashCode());
        assertEquals(sowyer.hashCode(), sowyerTwin.hashCode());
        assertNotEquals(sowyer.hashCode(), insomnia.hashCode());
    }

    @Test
    void testToString() {
        System.out.println(sowyer);
        String tomSowyer = sowyer.toString();
        assertTrue(tomSowyer.contains("Tom Sowyer")&&tomSowyer.contains("Twain")&&tomSowyer.contains("isbn=22334455"));

    }
}