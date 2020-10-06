package com.nikolenko.homeworks.homework_08;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {
    static Author author;
    static Author authorSame;
    static Author authorCopy;
    static Author authorDiff;

    @BeforeAll
    static void setUp() {
        author = new Author("James", "Jones", new Date(1921, 10, 6));
        authorSame = new Author("James", "Jones", new Date(1921, 10, 6));
        authorCopy = new Author(author);
        authorDiff = new Author("Jones", "James", new Date(1921, 10, 6));
    }

    @Test
    void testToString() {

       String str = "Author{" +
                "firstName='" + "James" + '\'' +
                ", lastName='" + "Jones" + '\'' +
                ", dateOfBirth=" +  "'6" + '.' + "11" + '.' + "1921'" +
                '}';

        assertEquals(str, author.toString());
        System.out.println(str);
        System.out.println(author.toString());
    }

    @Test
    void testEquals() {
        assertTrue(author.equals(author));
        assertTrue(author.equals(authorSame));
        assertTrue(authorCopy.equals(author));
        assertFalse(author.equals(authorDiff));
    }

    @Test
    void testHashCode() {
        assertTrue(author.hashCode() == authorSame.hashCode() && author.hashCode() == authorCopy.hashCode());
    }

}