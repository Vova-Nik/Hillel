package com.nikolenko.homeworks.homework_10.AutoTypes;

import com.nikolenko.homeworks.homework_10.Auto;
import com.nikolenko.homeworks.homework_10.Sellable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Value
public class SpecTech extends Auto implements Sellable, Cloneable {
    String type;
    int weight;

    public Sellable getCopy() {
        return new SpecTech(new Auto(getIssueYear(), getCountryCode(), getBrand(), getPrice(), getEquipment(), getSoldDate(), getBuyer()), type, weight);
    }

    public SpecTech(Auto auto, String type, int weight) {
        super(auto);
        this.type = type;
        this.weight = weight;
    }
}
