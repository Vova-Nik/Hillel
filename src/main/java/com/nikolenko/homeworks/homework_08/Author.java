package com.nikolenko.homeworks.homework_08;

import java.util.Date;

public class Author {
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;

     Author(Author author) {
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.dateOfBirth = author.getDateOfBirth();
    }

    public Author(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new Date(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDate());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDate());
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" +  dateOfBirth.getDate() + '.' + (dateOfBirth.getMonth() + 1) + '.' + dateOfBirth.getYear() +
                "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        if (this.hashCode() != author.hashCode()) {
            return false;
        }
        return this.toString().equals(author.toString());
    }

    @Override
    public int hashCode() {
        String atr = firstName + lastName + dateOfBirth.getDate() + dateOfBirth.getMonth() + dateOfBirth.getYear();
        char[] chArr = atr.toCharArray();
        int hash = 0;
        for (char ch : chArr) {
            hash = (hash<<1)  + ch;
            hash *= 31;
        }
        return hash;
    }

}
