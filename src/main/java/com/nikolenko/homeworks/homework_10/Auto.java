package com.nikolenko.homeworks.homework_10;

import lombok.*;

/**
 * "Автомобиль" (марка, цена, комплектация, дата продажи, ФИО покупателя)
 */

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
//@NoArgsConstructor
@Data
public class Auto extends Transport {
    private final String brand;
    private final int price;
    private final Equipment equipment;
    private final AutoCalendar soldDate;
    private final Person buyer;

    public Auto(Auto auto) {
        super(auto.getIssueYear(), auto.getCountryCode());
        this.brand = auto.getBrand();
        this.price = auto.getPrice();
        this.equipment = auto.getEquipment();
        this.soldDate = auto.getSoldDate();
        this.buyer = auto.getBuyer();
    }

    public Auto(int transportYear, Country country, String brand, int price, Equipment equipment, AutoCalendar soldDate, Person buyer) {
        super(transportYear, country);
        this.brand = brand;
        this.price = price;
        this.equipment = equipment;
        this.soldDate = new AutoCalendar(soldDate);
        this.buyer = new Person(buyer);
    }

//    int getTransportYear(){
//        return this.
//    }

}
