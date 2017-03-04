package com.tasks.task2.solvers;

/* bx + c = 0 */
public class LinearEquationSolver implements EquationSolver {
    private static String PARAMS = "b, c";
    private double b;
    private double c;

    public LinearEquationSolver() {
    }

    public LinearEquationSolver(double b, double c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public String solve() {
        if (b != 0) {
            double x = -c / b;
            return "Root of a linear equation is: x = " + String.format("%.3f", x);
        } else {
            return "It is not a linear equation";
        }
    }

    @Override
    public void initialize(double[] params) {
        if (params.length != 2) {
            throw new RuntimeException("2 parameters are needed");
        }

        b = params[0];
        c = params[1];
    }

    @Override
    public String getName() {
        return "linear";
    }

    @Override
    public String getParams() {
        return PARAMS;
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

    @Override
    public int getParamsNumbers() {
        return 2;
    }

}
