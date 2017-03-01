package com.tasks;

import com.tasks.solvers.EquationSolver;
import com.tasks.solvers.LinearEquationSolver;
import com.tasks.solvers.QuadraticEquationSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestDrive {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EquationSolver equationSolver;

        while (true) {
            System.out.println("Enter type of an equation which you would like to solve: linear/quadratic");
            try {
                String type = br.readLine();
                if ("linear".equalsIgnoreCase(type)) {
                    readParametersfromConsoleAndSolve(new LinearEquationSolver());
                    break;
                }

                if ("quadratic".equalsIgnoreCase(type)) {
                    readParametersfromConsoleAndSolve(new QuadraticEquationSolver());
                    break;
                }

                System.out.println("Incorrect type of an equation, enter only linear or quadratic");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readParametersfromConsoleAndSolve(EquationSolver equationSolver) throws IOException {
        equationSolver.readParametersfromConsole();
        System.out.println(equationSolver.toString());
        System.out.println(equationSolver.solve() + "\n");
    }
}
