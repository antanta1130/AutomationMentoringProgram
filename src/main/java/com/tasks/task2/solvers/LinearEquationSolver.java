package com.tasks.task2.solvers;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import com.tasks.task2.MyReader;

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
    public void readParameters(Reader reader) throws IOException {
        MyReader myReader = new MyReader(reader);
        Map<String, Double> result = myReader.readDoubleValuesAndVerify(new String[] { "b", "c" });

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
