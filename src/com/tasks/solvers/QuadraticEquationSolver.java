package com.tasks.solvers;

/* ax^2 + bx + c = 0 */
public class QuadraticEquationSolver implements EquationSolver {
    private double a;
    private double b;
    private double c;
    private double discriminant;

    public QuadraticEquationSolver() {
    }

    public QuadraticEquationSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        discriminant = discriminant();
    }

    public double discriminant() {
        return b * b - 4 * a * c;
    }

    public String solve() {
        double x1;
        double x2;

        if (a != 0) {
            if (discriminant >= 0) {
                x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                return "Roots of quadratic equation are: x1 = " + x1 + "; x2 = " + x2;
            } else {
                return "There are no real roots";
            }
        } else {
            return "It is not a quadratic equation";
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
