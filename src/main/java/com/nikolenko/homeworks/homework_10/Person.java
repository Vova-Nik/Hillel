package com.nikolenko.homeworks.homework_10;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Person {
     String firstName;
     String lastName;

    public Person(Person person) {
        firstName = person.firstName;
        lastName = person.lastName;
    }
}
