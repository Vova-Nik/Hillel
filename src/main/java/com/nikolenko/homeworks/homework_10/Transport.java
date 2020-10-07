package com.nikolenko.homeworks.homework_10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data   //ToString, EqualsAndHashCode, Getter
@AllArgsConstructor
public abstract class Transport {
//(Создать родительский абстрактный класс "Transport" (год выпуска, страна производитель)
    int issueYear;
    Country countryCode;
}
