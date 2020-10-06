package com.nikolenko.homeworks.homework_08;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
        static Author author;

        static Book book;
        static Book bookSame;
        static Book bookCopy;
        static Book bookDiff;

        @BeforeAll
        static void setUp() {
                author = new Author("James", "Jones", new Date(1921, 10, 6));

                book = new Book(author,new Date(1991,8,22), Book.Genre.FAIRY_TALE , 12345678l);
                bookSame = new Book(author,new Date(1991,8,22), Book.Genre.FAIRY_TALE , 12345678l);
                bookCopy = new Book(book);
                bookDiff = new Book(author,new Date(1991,8,22), Book.Genre.FANTASY, 12345678l);
        }

        @Test
        void testToString(){
                String tmpl = "Book{author='Author{firstName='James', lastName='Jones', dateOfBirth='6.11.1921'}', issueDate='22.8.1991', genre='Fairy tale', isbn='12345678'}";
                assertEquals(book.toString(),tmpl);
                assertEquals(book.toString(),bookSame.toString());
                assertEquals(book.toString(),bookCopy.toString());
                assertNotEquals(book.toString(), bookDiff.toString());
        }

        @Test
        void testEquals(){
                assertTrue(book.equals(bookSame));
                assertTrue(book.equals(bookCopy));
                assertTrue(bookCopy.equals(bookSame));
                assertFalse(book.equals(bookDiff));
        }

        @Test
        void testHashCode(){
                assertTrue(book.hashCode() == bookCopy.hashCode());
                assertTrue(book.hashCode() == bookSame.hashCode());
                assertNotEquals(book.hashCode(),0);
                Book bookWeryDiff = new Book(author,new Date(2020,11,2), Book.Genre.BELLETRE, 100l);
                System.out.println("book hash = " + String.format("0x%08X",book.hashCode()));
                System.out.println("bookDiff hash = " + String.format("0x%08X",bookDiff.hashCode()));
                System.out.println("bookWeryDiff hash = " + String.format("0x%08X",bookWeryDiff.hashCode()));
        }
}
