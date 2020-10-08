package com.nikolenko.homeworks.homework_10.AutoTypes;

import com.nikolenko.homeworks.homework_10.Auto;
import com.nikolenko.homeworks.homework_10.Person;
import com.nikolenko.homeworks.homework_10.Sellable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Value

public class SecondHandAuto extends Auto implements Sellable, Cloneable {
    int distanceTravelled;
    Person owner;

    public Sellable getCopy() {
        return new SecondHandAuto(new Auto(getIssueYear(), getCountryCode(), getBrand(), getPrice(), getEquipment(), getSoldDate(), getBuyer()), distanceTravelled, new Person(owner.getFirstName(), owner.getLastName()));
    }

    public SecondHandAuto(Auto auto, int distanceTravelled, Person owner) {
        super(auto);
        this.distanceTravelled = distanceTravelled;
        this.owner = new Person(owner.getFirstName(), owner.getLastName());
    }
}
