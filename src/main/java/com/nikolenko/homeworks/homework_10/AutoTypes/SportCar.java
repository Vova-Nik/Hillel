package com.nikolenko.homeworks.homework_10.AutoTypes;

import com.nikolenko.homeworks.homework_10.Auto;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Value
public class SportCar extends Auto{
    int maxSpeed;
    int engineVolume;
    int enginePower;

    public SportCar(Auto auto, int maxSpeed, int engineVolume, int enginePower) {
        super(auto);
        this.maxSpeed = maxSpeed;
        this.engineVolume = engineVolume;
        this.enginePower = enginePower;
    }
}









