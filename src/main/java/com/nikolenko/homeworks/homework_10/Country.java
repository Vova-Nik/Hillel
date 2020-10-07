package com.nikolenko.homeworks.homework_10;

public enum Country {
    ES ("Spain"),
    FR ("France"),
    GB ("United Kingdom"),
    IN ("India"),
    IT ("Italy"),
    JP ("Japan"),
    KR ("Korea"),
    PL ("Polland"),
    RO ("Romania"),
    SE ("Sweden"),
    SK ("Slovakia"),
    US ("USA"),
    UA ("Ukraine");

    private final String title;

    Country(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
