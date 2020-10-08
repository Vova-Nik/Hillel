package com.nikolenko.homeworks.homework_10;

import com.nikolenko.homeworks.homework_10.AutoTypes.SecondHandAuto;
import com.nikolenko.homeworks.homework_10.AutoTypes.SportCar;

public class Model {
    private final int SIZE = 1000;
    private final Auto[] autos;
    private int index;
    private int quantity;

    public Model() {
        autos = new Auto[1000];
        index = 0;
        quantity = 0;
    }

    boolean addAuto(Auto auto) {
        if (index + 1 >= SIZE) {
            return false;
        }
        quantity++;
        autos[index] = new Auto(auto);
        index++;
        return true;
    }
    boolean add(SecondHandAuto auto) {
        if (index + 1 >= SIZE) {
            return false;
        }
        quantity++;
        autos[index] = new Auto(auto);
        index++;
        return true;
    }
    boolean add(SportCar auto) {
        if (index + 1 >= SIZE) {
            return false;
        }
        quantity++;
        autos[index] = new Auto(auto);
        index++;
        return true;
    }

    public Auto[] getList() {
        Auto[] autoList = new Auto[quantity];
        for (int i = 0; i < autoList.length; i++) {
            autoList[i] = new Auto(autos[i]);
        }
        return autoList;
    }
}
