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
public class SportCar extends Auto implements Sellable, Cloneable {
    int maxSpeed;
    int engineVolume;
    int enginePower;

    public Sellable getCopy() {
        return new SportCar(new Auto(getIssueYear(), getCountryCode(), getBrand(), getPrice(), getEquipment(), getSoldDate(), getBuyer()), maxSpeed, engineVolume, enginePower);
    }

    public SportCar(Auto auto, int maxSpeed, int engineVolume, int enginePower) {
        super(auto);
        this.maxSpeed = maxSpeed;
        this.engineVolume = engineVolume;
        this.enginePower = enginePower;
    }
}









