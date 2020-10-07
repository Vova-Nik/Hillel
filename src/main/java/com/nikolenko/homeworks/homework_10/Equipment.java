package com.nikolenko.homeworks.homework_10;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Value
public class Equipment {

    boolean automaticTransmission;
    boolean automaticGlass;
    boolean conditioner;
    boolean climateControl;
    boolean roofHatch;

}
