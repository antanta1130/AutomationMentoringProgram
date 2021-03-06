package com.tasks.task2.solvers;

/* ax^2 + bx + c = 0 */
public class QuadraticEquationSolver implements EquationSolver {
    private static String PARAMS = "a, b, c";
    private double a;
    private double b;
    private double c;

    public QuadraticEquationSolver() {
    }

    public QuadraticEquationSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double discriminant() {
        return b * b - 4 * a * c;
    }

    @Override
    public String solve() {
        double x1;
        double x2;
        double discriminant = discriminant();

        if (a != 0) {
            if (discriminant >= 0) {
                x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                return "Roots of a quadratic equation are: x1 = " + String.format("%.3f", x1) + "; x2 = " + String.format("%.3f", x2);
            } else {
                return "There are no real roots, discriminant = " + discriminant;
            }
        } else {
            return "It is not a quadratic equation";
        }
    }

    @Override
    public void initialize(double[] params) {
        if (params.length != 3) {
            throw new RuntimeException("3 parameters are needed");
        }

        a = params[0];
        b = params[1];
        c = params[2];
    }

    @Override
    public String getName() {
        return "quadratic";
    }

    @Override
    public String getParams() {
        return PARAMS;
    }

    @Override
    public String toString() {
        return "Quadratic equation: " + a + "x^2 " + (b >= 0 ? "+ " + b : b) + "x " + (c >= 0 ? "+ " + c : c) + " = 0";
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

    @Override
    public int getParamsNumbers() {
        return 3;
    }
}
