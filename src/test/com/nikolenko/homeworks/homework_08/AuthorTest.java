package com.nikolenko.homeworks.homework_08;

import java.util.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {
    static Author author;

    @BeforeAll
    static void setUp() {
        author = new Author("James", "Jones", new Date(1921, 10, 6));
    }

    @Test
    void testToString(){
        assertEquals("Author\nFirst name - James\nLast Name - Jones\nDate of birth - 6.11.1921", author.toString());
    }

}
