package com.nikolenko.homeworks.homework_08;

import java.util.Date;

public class Book {
    private final Author author;
    private final Date issueDate;
    private final Genre genre;
    private final long isbn;

    enum Genre {
        SCIENCE ("Science"),
        BELLETRE ("Belletre"),
        FANTASY ("Fantasy"),
        SCIENCE_FICTION ("Science fiction"),
        DETECTIVE ("Detective"),
        FAIRY_TALE ("Fairy tale");

        private final String title;

        Genre(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public Book(Author author, Date issueDate, Genre genre, Long isbn) {
        this.author = author;
        this.issueDate = new Date(issueDate.getYear(), issueDate.getMonth(), issueDate.getDate());
        this.genre = genre;
        this.isbn = isbn;
    }

     Book(Book other) {
        this.author = other.getAuthor();
        this.issueDate = other.getIssueDate();
        this.genre = other.getGenre();
        this.isbn = other.getIsbn();
    }

    public Author getAuthor() {
        return new Author(author);
    }

    public Date getIssueDate() {
        return new Date(issueDate.getYear(), issueDate.getMonth(), issueDate.getDate());
    }

    public Genre getGenre() {
        return genre;
    }

    public Long getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        String date = issueDate.getDate() + "." + issueDate.getMonth() + "." + issueDate.getYear();
        return "Book{" +
                "author=" + '\'' + author + '\'' +
                ", issueDate=" + '\'' + date + '\'' +
                ", genre=" + '\'' + genre.title + '\'' +
                ", isbn=" + '\'' + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (this.hashCode() != book.hashCode()) {
            return false;
        }
        return author.equals(book.author) &&
                (issueDate.getYear() == book.issueDate.getYear() &&
                        issueDate.getMonth() == book.issueDate.getMonth() &&
                        issueDate.getDay() == book.issueDate.getDay()) &&
                genre.toString().equals(book.genre.toString()) &&
                isbn == book.isbn;
    }


    @Override
    public int hashCode() {
        int hash = author.hashCode();
        hash += (issueDate.getYear() * 7 + issueDate.getMonth() * 3 + issueDate.getDate()) * 31;
        hash += isbn % hash;

        char[] chArr = genre.toString().toCharArray();
        for (char ch : chArr) {
            hash = (hash << 1) + ch;
            hash *= 31;
        }
        return hash;
    }
}
