package com.tasks.task2.decisionmaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.tasks.task2.solvers.EquationSolver;
import com.tasks.task2.solvers.LinearEquationSolver;
import com.tasks.task2.solvers.QuadraticEquationSolver;

public class DecisionMaker {
    private EquationSolver equationSolver;
    private Reader reader;

    private EquationSolver chooseTypeOfEquation(String type) {
        if ("linear".equalsIgnoreCase(type)) {
            return new LinearEquationSolver();
        }

        if ("quadratic".equalsIgnoreCase(type)) {
            return new QuadraticEquationSolver();
        }

        return null;
    }

    private Reader chooseTypeOfInputStream(String type) throws FileNotFoundException {
        if ("console".equalsIgnoreCase(type)) {
            return new InputStreamReader(System.in);
        } else {
            return new FileReader(new File(type));
        }
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

            while (reader == null) {
                System.out.println("Enter the way of getting parameters: console or file name");
                type = br.readLine();
                reader = chooseTypeOfInputStream(type);
            }

            equationSolver.readParameters(reader);
            System.out.println(equationSolver.toString());
            System.out.println(equationSolver.solve() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
