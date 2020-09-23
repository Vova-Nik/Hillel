package com.nikolenko.homeworks.homework_05;

import java.util.Date;

/**
 * Создайте POJO Order который будет иметь поля item, deliveryDate(класс Date), size, price
 */

public class Order {
    String item;        //name of item
    Date deliveryDate;
    int size;           //gramm
    int price;          //Hrivna

    public Order() {
        size = 0;
        price = 0;
        item = " ";
        deliveryDate = new Date();
    }

    public Order(String item, Date deliveryDate, int size, int price) {
        this.item = item;
        this.deliveryDate = deliveryDate;
        this.size = size;
        this.price = price;

    }

    public boolean setItem(String item) {
        if (item.length() < 3) {
            return false;
        }
        if (item.length() > 128) {
            return false;
        }
        this.item = item;
        return true;
    }

    public boolean setDeliveryDate(Date deliveryDate) {
        Date now = new Date();

        if (deliveryDate.before(now)) {
            return false;
        }
        this.deliveryDate = deliveryDate;
        return true;
    }

    public boolean setSize(int size) {
        if (size < 1) {
            return false;
        }
        if (size > 10000000) {
            return false;
        }
        this.size = size;
        return true;
    }

    public boolean setPrice(int price) {
        if (price < 0) {
            return false;
        }
        this.price = price;
        return true;
    }

    public String getItem() {
        return item;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "item='" + item + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
