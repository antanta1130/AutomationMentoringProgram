package com.tasks;

import com.tasks.task2.solvers.EquationSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.tasks.task2.decisionmaker.DecisionMaker.chooseTypeOfEquation;

public class TestDrive {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EquationSolver equationSolver = null;
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
