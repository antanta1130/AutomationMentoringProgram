package com.tasks.task2.decisionmaker;

import com.tasks.task2.solvers.EquationSolver;
import com.tasks.task2.solvers.LinearEquationSolver;
import com.tasks.task2.solvers.QuadraticEquationSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecisionMaker {
    private EquationSolver equationSolver;

    private EquationSolver chooseTypeOfEquation(String type) {
        if ("linear".equalsIgnoreCase(type)) {
            return new LinearEquationSolver();
        }

        if ("quadratic".equalsIgnoreCase(type)) {
            return new QuadraticEquationSolver();
        }

        return null;
    }

    public void readTypeOfEquationFromConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String type;

        try {
            while (equationSolver == null) {
                System.out.println("Enter type of an equation which you would like to solve: linear/quadratic");
                type = br.readLine();
                equationSolver = chooseTypeOfEquation(type);
            }

            equationSolver.readParametersfromConsole();
            System.out.println(equationSolver.toString());
            System.out.println(equationSolver.solve() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
