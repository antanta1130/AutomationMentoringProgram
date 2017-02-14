package com.tasks;

/**
 * Created by Tetiana_Kotova on 2/14/2017.
 */
public class Task1 {
    public static void main(String[] args) {
        double a = 1, b = - 2, c = 1;
        double x1, x2;
        double D = b * b - 4 * a * c;

        if (D >= 0) {
            x1 = (-b + Math.sqrt(D))/(2 * a);
            x2 = (-b - Math.sqrt(D))/(2 * a);
            System.out.println("x1 = " + x1 + "; x2 = " + x2);
        }
        else System.out.println("There are no real roots");
    }
}
