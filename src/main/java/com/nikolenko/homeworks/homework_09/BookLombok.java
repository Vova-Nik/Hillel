package com.nikolenko.homeworks.homework_09;

import lombok.Value;

import java.util.Date;

@Value

public class BookLombok {

    private final AuthorLombok author;
    private final Date issueDate;
    private final Genre genre;
    private final long isbn;
    private final String title;

    public Date getIssueDate() {
        return new Date(issueDate.getTime());
    }

    @Override
    public String toString() {
        return "BookLombok(author=" + author.toString() + ")" + ", title=" + title + ", genre=" + genre.getTitle() + ", issueDate=" + issueDate.toString() + ", isbn=" + isbn;
    }
}

