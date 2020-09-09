package com.nikolenko.homeworks.homework_01;

import com.nikolenko.homeworks.homework_00.KeyBoard;

public class HW1Main {
    public static void main(String[] args) {
        String greeting = "Welcome Hillel, Java course, Homework_01 Nikolenko!";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++)
            System.out.print("=");
        System.out.println();
        KeyBoard keyBoard = new KeyBoard();

        nathan(keyBoard);

        keyBoard.close();
    }
    private static void nathan(KeyBoard kbd){
        System.out.println("Practice 1\n Nathan loves cycling");
        System.out.println("Please, enter any number XX,XXX as hours");
        double nHours = kbd.giveDouble();
        int liters = (int) Math.floor( nHours*0.5);
        String lit = liters > 1 ? " liters." : " liter.";
        System.out.print("Nathan should drink at least " + liters + lit);
    }

}
