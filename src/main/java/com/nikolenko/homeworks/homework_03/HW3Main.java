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
        //       char ch ='1';
        //       System.out.println(primitivInfo.info(ch));

        /* *********************** page 27 ******************************/
        String name = "Иван";
        String surname = "Иванов";
        String fullName = surname + " " + name;
        System.out.println(fullName);  //        Иванов Иван

        String s1 = "abc" + 2 + 2;
        System.out.println(s1);//  abc22
        String s2 = 2 + 2 + "abc";
        System.out.println(s2); //  4abc

        /* *********************** Page 28 ******************************/
        System.out.println(128 >> 1);     //64
        System.out.println(256 >> 4);     //16
        System.out.println(-256 >> 4);    //-16

        System.out.println(128 >>> 1);    //64
        System.out.println(256 >>> 4);    //16
        System.out.println(-256 >>> 4);   //268435440

        System.out.println(128 << 1);     //256
        System.out.println(16 << 2);      //64

        /* *********************** Page 29 ******************************/
        long lVal = 1000;

            // int iVal = lVal; // error at coplilation phase


        /* *********************** Page 30 ******************************/

        double d = 3.14159265359;
        float f = (float) d; // Потеря точности
        System.out.println(f); // 3.1415927
        int i = 257;
        byte b = (byte) i; // Потеря значимости
        System.out.println(b); // 1

        /* *********************** Page 32 ******************************/

        Integer p32int = 2147483647;
        float p32float = p32int.floatValue();
        System.out.println("Page 32 integer 2147483647 to float" + p32float); //Page 32 integer 2147483647 to float2.14748365E9
        p32float = p32int.floatValue();
        System.out.println("Page 32 integer -2147483648 to float" + p32float); //Page 32 integer -2147483648 to float2.14748365E9

        /* *********************** Page 33 ******************************/
        int chinaPopulation = 1360000000;
        int indiaPopulation = 1240000000;
        int total = chinaPopulation + indiaPopulation;
        System.out.println("total = " + total); // -1694967296

        byte b1 = 1;
        byte b2 = 2;
        //byte b3=b1+b2; // compilation error

        /* *********************** Page 34 ******************************/
        System.out.println("*********************** Page 34 ******************************");
        int p34i = 123456789;
        float p34f = p34i;
        double p34d = p34i;
        short p34s = (short) p34i;
        System.out.println("int: " + p34i);        //int: 123456789
        System.out.println("float: " + p34f);      //float: 1.23456792E8
        System.out.println("double: " + p34d);     //double: 1.23456789E8
        System.out.println("short: " + p34s);      //short: -13035


        /* *********************** Page 35 ******************************/
        System.out.println("*********************** Page 35 ******************************");
        int p35a = 1;
        int p35b = 0;
        try {
            int p35c = p35a / p35b;

        } catch (Exception e) {
            System.out.println("Error happend - " + e);         //java.lang.ArithmeticException: / by zero
        }

        /* *********************** Page 36 ******************************/
        System.out.println("*********************** Page 36 ******************************");
        System.out.println(page36());

        /* *********************** Page 37 ******************************/
        System.out.println("*********************** Page 37 ******************************");
        System.out.println(page37());

        /* *********************** Page 39 ******************************/
        System.out.println("*********************** Page 39 ******************************");
        page39();
        /*
        int a=1; // Переопределяем. Так делать допускается.
        {
            a=2; // Ok
            int a=3; // Error: already defined
            int b=4; // Ok
        }
        b=5; // Error: cannot find
        int b=6; // Ok
        */
        System.out.println("Performed");

        /* *********************** Page 45 ******************************/
        System.out.println("*********************** Page 45 ******************************");
        int color = 0xffffff;
        int colorNum = 0;
        switch (colorNum) {
            case 0:
                color = 0xff0000;   //red
                break;
            case 1:
                color = 0x00ff00;   //green
                break;
            case 2:
                color = 0x0000ff;   //blue
                break;
            default:
                color = 0x000000;   //black
                break;
        }
        System.out.println("Performed");
    }

    /*Method just  to escape vars a,b,c, renaming*/
    private static StringBuilder page36() {
        double a = 1;
        double b = 0;
        double c = a / b;
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(c).append("\n");                                  //Infinity
        toReturn.append("c+1 = ").append(c + 1).append("\n");             //c+1 = Infinity
        toReturn.append("+0.0 == -0.0 : " + (0.0 == -0.0)).append("\n");  //+0.0 == -0.0 : true
        toReturn.append("a/(+0.0) = ").append(a / (+0.0)).append("\n");       //a/(+0.0) = Infinity
        toReturn.append("a/(-0.0) = ").append(a / (-0.0)).append("\n");       //a/(-0.0) = -Infinity
        return toReturn;
    }

    /*Method just  to escape vars a,b,c, renaming*/
    private static StringBuilder page37() {
        double a = 0;
        double b = 0;
        double c = a / b;
        System.out.println("c =" + c);
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("c+0 =").append(c + 0).append("\n");                     //c+0 =NaN
        toReturn.append("c<0 =").append(c < 0).append("\n");                     //c<0 =false
        toReturn.append("c>0 =").append(c > 0).append("\n");                     //c>0 =false
        toReturn.append("c==0 =").append(c == 0).append("\n");                   //c==0 =false
        toReturn.append("c!=0 =").append(c != 0).append("\n");                   //c!=0 =true
        toReturn.append("c==c =").append(c == c).append("\n");                   //c==c =false
        toReturn.append("c!=c =").append(c != c).append("\n");                   //c!=c =true
        toReturn.append("c == NaN: ").append(c == Double.NaN).append("\n");      //c == NaN: false
        toReturn.append("c is NaN: ").append(Double.isNaN(c)).append("\n");      //c is NaN: true
        return toReturn;
    }

    private static void page39() {
        int a = 1; // Переопределяем. Так делать допускается.
        {
            a = 2; // Ok
           // int a = 3;         // Error: already defined
            int b = 4; // Ok
        }
        //b=5;                  // Error: cannot find
        int b = 6; // Ok
    }

}



