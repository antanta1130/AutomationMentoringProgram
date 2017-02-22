package com.tasks.solvers;

/* bx + c = 0 */
public class LinearEquationSolver implements EquationSolver {
    private double b;
    private double c;

    public LinearEquationSolver() {
    }

    public LinearEquationSolver(double b, double c) {
        this.b = b;
        this.c = c;
    }

    public String solve() {
        double x;

        if (b != 0) {
            x = -c / b;
            return "Root of a linear equation is: x = " + x;
        } else {
            return "It is not a linear equation";
        }
    }

    @Override
    public String toString() {
        return "Linear equation: " + b + "x " + (c >= 0 ? "+ " + c : c) + " = 0";
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
