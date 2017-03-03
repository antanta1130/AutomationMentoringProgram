package com.tasks.task2.solvers;

import com.tasks.task2.Reader;

import java.io.IOException;
import java.util.Map;

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
        if (b != 0) {
            double x = -c / b;
            return "Root of a linear equation is: x = " + String.format("%.3f", x);
        } else {
            return "It is not a linear equation";
        }
    }

    public void readParametersfromConsole() throws IOException {
        Map<String, Double> result = Reader.readDoubleValueFromConsoleAndVerify(new String[] { "b", "c" });

        for (Map.Entry<String, Double> pair : result.entrySet()) {
            switch (pair.getKey()) {
            case "b":
                setB(pair.getValue());
                break;
            case "c":
                setC(pair.getValue());
                break;
            }
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