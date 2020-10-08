package com.nikolenko.homeworks.homework_10.AutoTypes;
import com.nikolenko.homeworks.homework_10.Auto;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Value
public class SpecTech extends Auto{
    String type;
    int weight;
    public SpecTech(Auto auto, String type, int weight) {
        super(auto);
        this.type = type;
        this.weight = weight;
    }
}
