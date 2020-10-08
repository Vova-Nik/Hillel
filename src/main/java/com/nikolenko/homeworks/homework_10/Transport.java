package com.nikolenko.homeworks.homework_10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**(Создать родительский абстрактный класс "Transport" (год выпуска, страна производитель)*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Transport {
    int issueYear;
    Country countryCode;
}
