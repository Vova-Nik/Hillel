package com.nikolenko.homeworks.homework_10;

import com.nikolenko.homeworks.homework_10.AutoTypes.SecondHandAuto;
import com.nikolenko.homeworks.homework_10.AutoTypes.SpecTech;
import com.nikolenko.homeworks.homework_10.AutoTypes.SportCar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    static SecondHandAuto secondHandAuto1;
    static SecondHandAuto secondHandAuto2;
    static SportCar sportCar1;
    static SportCar sportCar2;
    static SpecTech specTech1;
    static SpecTech specTech2;
    static Model model;

    static Equipment equipmentCompl;
    static Auto auto;
    static Person owner;
    static Person buyer;
    static AutoCalendar autoCalendar;

    @BeforeAll
    static void initiate() {
        owner = new Person("Robin", "Good");
        buyer = new Person("Johny", "Walker");
        autoCalendar = new AutoCalendar(2017, Calendar.MARCH, 25);
        equipmentCompl = new Equipment(true, true, true, false, true);
        auto = new Auto(2006, Country.JP, "Toyota", 7000, equipmentCompl, autoCalendar, buyer);
        secondHandAuto1 = new SecondHandAuto(auto, 100000, owner);
        sportCar1 = new SportCar(auto, 200, 2000, 200);
        specTech1 = new SpecTech(auto, "Caterpillar", 8000);
        secondHandAuto2 = new SecondHandAuto(auto, 200000, owner);
        sportCar2 = new SportCar(auto, 200, 3000, 300);
        specTech2 = new SpecTech(auto, "Caterpillar", 12000);

        model = new Model();

    }


    @Test
    void addAuto() {
        assertTrue(model.addAuto(secondHandAuto1));
        assertTrue(model.addAuto(secondHandAuto2));
        assertTrue(model.addAuto(sportCar1));
        assertTrue(model.addAuto(sportCar2));
        assertTrue(model.addAuto(specTech1));
        assertTrue(model.addAuto(specTech2));
    }

    @Test
    void getList() {
        Auto[] list = model.getList();
        for (Auto a : list
        ) {
            System.out.println(a);
        }
    }
}