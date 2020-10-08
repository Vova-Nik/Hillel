package com.nikolenko.homeworks.homework_10.AutoTypes;

import com.nikolenko.homeworks.homework_10.Auto;
import com.nikolenko.homeworks.homework_10.Person;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Value

public class SecondHandAuto extends Auto {
    int distanceTravelled;
    Person owner;

    public SecondHandAuto(Auto auto, int distanceTravelled, Person owner) {
        super(auto);
        this.distanceTravelled = distanceTravelled;
        this.owner = new Person(owner.getFirstName(), owner.getLastName());
    }
}
