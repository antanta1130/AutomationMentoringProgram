package com.tasks.solvers;

import com.tasks.Reader;

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
            return "Root of a linear equation is: x = " + String.format("%.3f", x);
        } else {
            return "It is not a linear equation";
        }
    }

    public void readParametersfromConsole() {
        setB(Reader.readDoubleValueFromConsoleAndVerify("b"));
        setC(Reader.readDoubleValueFromConsoleAndVerify("c"));
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
