package com.nikolenko.homeworks.homework_01;

public class QuadraticEquation {
    KeyBoard keyBoard;

    QuadraticEquation(KeyBoard kbd) {
        keyBoard = kbd;

    }

    public void proceed() {
        double[] triangle = keyBoard.giveTriangle("Input three double values for coefs of quadratic equation 'a', 'b', 'c' separated by 'space' ", "Impossible to translate to pair of double values, try again", "It's OK, Thanks!");
        double a = triangle[0];
        double b = triangle[1];
        double c = triangle[2];
        if (a == 0) {
            System.out.println(" 'a' can not be zerro!");
            return;
        }
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        double d = b * b - 4 * a * c;
        if (d < 0) {
            System.out.println("Discriminant = " + d + ". There is no solution to the equation");
            return;
        }
        if (d == 0) {
            System.out.println("Discriminant = " + d + ". There is only one solution to the equation");
            double x = -b / (2 * a);
            System.out.println("x = " + x);
            return;
        }
        if (d > 0) {
            System.out.println("Discriminant = " + d + ". There are two solutions to the equation");
            
            double x1 = (-b + Math.pow(d, 1.0 / 2)) / (2 * a);
            double x2 = (-b - Math.pow(d, 1.0 / 2)) / (2 * a);
            double[] solutions = {0, 0};

            solutions[0] = x1;
            solutions[1] = x2;
            if (x1 > x2) {
                solutions[0] = x2;
                solutions[1] = x1;
            }

            System.out.println("First solution = " + solutions[0]);
            System.out.println("Second solution = " + solutions[1]);
        }

    }
}


