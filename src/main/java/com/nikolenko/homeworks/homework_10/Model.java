package com.nikolenko.homeworks.homework_10;

public class Model {
    private final int SIZE = 1000;
    private final Sellable[] peaces;
    private int index;
    private int quantity;

    public Model() {
        peaces = new Sellable[1000];
        index = 0;
        quantity = 0;
    }

    boolean addAuto(Sellable someCar) {
        if (index + 1 >= SIZE) {
            return false;
        }
        for (Sellable vehicle: peaces
             ) {
            if(someCar.equals(vehicle)){
                return false;}
        }
        quantity++;
        peaces[index] = someCar.getCopy();
        index++;
        return true;
    }

    public Sellable[] getList() {
        Sellable[] autoList = new Sellable[quantity];
        for (int i = 0; i < autoList.length; i++) {
            autoList[i] = peaces[i].getCopy();
        }
        return autoList;
    }
}
