package com.nikolenko.homeworks.homework_09;

public enum Genre {
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
