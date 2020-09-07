package com.nikolenko.homeworks.homework_01;

public class Equations19_26 {
    private KeyBoard keyBoard;
    private double x;
    private double y = 1;

    Equations19_26(KeyBoard kbd) {
        keyBoard = kbd;
        System.out.println("Please, enter any number as X for calculating functions 19 to 26");
        x = keyBoard.giveDouble();
        try {
            equation19();
            equation20();
            equation21();
            equation22();
            equation23();
            equation24();
            equation25();
            equation26();
            //equation27();
        } catch (Exception e) {
            System.out.println("Math exception. Probably Division by Zerro");
        }
    }

    public boolean Proceed() {
        x = keyBoard.giveDouble();

        return true;
    }

    private double equation19() {
        y = Math.acos(Math.tan(5 * x / 3.1415) + Math.pow(x, 3.2) / 28);
        System.out.println("Task #19:");
        System.out.println("                          3,2  ");
        System.out.println("               5x       x      ");
        System.out.println("    arccos{tg(____)] + ---      = " + y);
        System.out.println("               \u03c0       28      ");
        System.out.println("\n");

        return y;
    }

    private void equation20() {
        y = (Math.pow(Math.log(x) * Math.log(x), (1d / 4)) + Math.tan(Math.cos(Math.PI * x))) * (Math.log(x / 10.5) + 1d / 3);
        System.out.println("Task #20:");
        System.out.println("Math.pow(Math.log(x)*Math.log(x),1/4)+Math.tan(Math.cos(Math.PI*x)))*(Math.log(x/10.5) +1/3) = " + y + "\n");
    }

    private void equation21() {
        y = (Math.pow(Math.log10(x), (1d / 4)) + Math.acos(x + 3)) * 1d / Math.abs(x + 2 * x * x);
        System.out.println("Task #21:");
        System.out.println("  y = (Math.pow(Math.log10(x), 1/4) + Math.acos(x + 3)) * 1/Math.abs(x + 2*x*x) = " + y + "\n");
    }

    private void equation22() {
        y = Math.asin(Math.log10(x) / x * x + 5 * x + 1) - Math.pow(x, 3.2) / 28;
        System.out.println("Task #22:");
        System.out.println("(Math.asin(Math.log10(x)/x*x + 5*x +1) - Math.pow(x,3.2)/28 = " + y + "\n");
    }

    private void equation23() {
        y = Math.acos(Math.tan(5 * x / Math.PI)) + Math.pow(x, 5.7) / 23;
        System.out.println("Task #23:");
        System.out.println("Math.acos(Math.tan(5*x/Math.PI)) + Math.pow(x,5.7)/23 = " + y + "\n");
    }

    private void equation24() {
        y = Math.atan(Math.abs(8.3 - 21 * x * x - .8 * x) / Math.pow((2.5 + 1 / x * x), (1d / 3)));
        System.out.println("Task #24:");
        System.out.println(" Math.atan(Math.abs(8.3 - 21*x*x - .8*x) / Math.pow((2.5 + 1/x*x),(1d/3))) = " + y + "\n");
    }

    private void equation25() {
        double numerator = Math.abs(Math.pow(x, 3.4) + 2.5 * Math.pow(x, 1.2) - 0.7);
        double denominator = Math.pow(Math.pow(Math.E, (2.5 * x)), 1d / 4);
        double underSqrt = Math.log10(Math.acos(numerator / denominator));
        y = Math.pow(underSqrt, 1d / 4) + 1;

        System.out.println("Task #25:");
        System.out.println("numerator = Math.abs(Math.pow(x,3.4) + 2.5 * Math.pow(x,1.2) - 0.7) = " + denominator);
        System.out.println("denominator = Math.pow(Math.pow(Math.E,(2.5 * x)), 1d/4) = " + numerator);
        System.out.println("underSqrt = Math.log10(Math.acos(numerator/denominator)) = " + underSqrt);
        System.out.println("y = Math.pow(underSqrt,1d/4) + 1 = " + y + "\n");
    }

    private void equation26() {
        y = Math.log(Math.abs(Math.sin(x))) + 2 * Math.E + +2 * Math.cos(Math.abs(x)) + 2;
        System.out.println("Task #26:");
        System.out.println("Math.log(Math.abs(Math.sin(x))) + 2*Math.E + + 2 * Math.cos(Math.abs(x)) + 2 = " + y + "\n");
    }
    //testing purposes
    //    private void equation27(){
    //        y = 1/x;
    //        System.out.println("1/ " + x + " = " + y );
    //        y = Math.pow(x,1d/2);
    //        System.out.println("Math.pow(" + x + ", 1d/2) = " + y  + "\n");
    //    }

}
