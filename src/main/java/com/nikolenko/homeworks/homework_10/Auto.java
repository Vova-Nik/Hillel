package com.nikolenko.homeworks.homework_10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * "Автомобиль" (марка, цена, комплектация, дата продажи, ФИО покупателя)
 */

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
//@AllArgsConstructor
public class Auto extends Transport {
    private final  String brand;
    private final  int price;
    private final  Equipment equipment;
    @ToString.Exclude
    private final  Calendar sold;
    private final Date soldDate;
    private final  Person buyer;

    Auto(int transportYear, Country country, String brand, int price, Equipment equipment, Calendar sold, Person buyer) {
        super(transportYear, country);
        this.brand = brand;
        this.price = price;
        this.equipment = equipment;
        this.sold = new GregorianCalendar(sold.get(Calendar.YEAR), sold.get(Calendar.MONTH), sold.get(Calendar.DATE), 0, 0, 0);
        soldDate = sold.getTime();
        this.buyer = new Person(buyer);
    }

}
