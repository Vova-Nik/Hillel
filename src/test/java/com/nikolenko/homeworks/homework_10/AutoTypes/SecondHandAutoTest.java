package com.nikolenko.homeworks.homework_10.AutoTypes;

import com.nikolenko.homeworks.homework_10.*;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecondHandAutoTest {
    static SecondHandAuto secondHandAuto;
    static SecondHandAuto secondHandAutoTwin;
    static SecondHandAuto secondHandAutoOther;

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
        secondHandAuto = new SecondHandAuto(auto, 100000, owner);
        secondHandAutoTwin = new SecondHandAuto(auto, 100000, owner);
        secondHandAutoOther = new SecondHandAuto(auto, 300000, owner);


    }
    @Test
    void testEquals() {
        assertEquals(secondHandAuto, secondHandAuto);
        assertEquals(secondHandAuto, secondHandAutoTwin);
        assertNotEquals(secondHandAuto,secondHandAutoOther);
    }

    @Test
    void testHashCode() {
        assertEquals(secondHandAuto.hashCode(), secondHandAuto.hashCode());
        assertEquals(secondHandAuto.hashCode(), secondHandAutoTwin.hashCode());
        assertNotEquals(secondHandAuto.hashCode(),secondHandAutoOther.hashCode());
    }

    @Test
    void testToString() {
        System.out.println(secondHandAuto);
        assertEquals(secondHandAuto.toString(), "SecondHandAuto(super=Auto(super=Transport(issueYear=2006, countryCode=JP), brand=Toyota, price=7000, equipment=Equipment(automaticTransmission=true, automaticGlass=true, conditioner=true, climateControl=false, roofHatch=true), soldDate=25.03.2017, buyer=Person(firstName=Johny, lastName=Walker)), distanceTravelled=100000, owner=Person(firstName=Robin, lastName=Good))");
    }
    @Test
    void testSportSpec() {
        SportCar sportCar = new SportCar(auto, 200, 2000, 200);
        SpecTech specTech = new SpecTech(auto, "Caterpillar", 8000);
        assertNotEquals(sportCar.hashCode(), specTech.hashCode());
        System.out.println(sportCar);
        System.out.println(specTech);
    }
}