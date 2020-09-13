package com.nikolenko.homeworks.homework_03;

/**
 * <b>It is the homework 3 java elementary course.</b>
 * *By Nikolenko Volodymyr
 * Просмотреть лекцию. Скопировать из нее приведенные примеры. В комментарии указать результаты выполнения примеров.
 */

public class HW3Main {

    public static void main(String[] args) {
        String greeting = "Welcome Hillel, Java course, Homework_03 Nikolenko!";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++)
            System.out.print("=");
        System.out.println();

        PrimitivInfo primitivInfo = new PrimitivInfo();
        byte bt = 0;
        System.out.println(primitivInfo.info(bt));
        short sh = 11;
        System.out.println(primitivInfo.info(sh));
        int it = 1000;
        System.out.println(primitivInfo.info(it));
        long lg = 262222977;
        System.out.println(primitivInfo.info(lg));
        float ft = 111;
        System.out.println(primitivInfo.info(ft));
        double db = 101010.3;
        System.out.println(primitivInfo.info(db));

        /* too long output!!!*/
                char ch ='1';
                System.out.println(primitivInfo.info(ch));
    }
}


