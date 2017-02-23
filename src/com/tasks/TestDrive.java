package com.tasks;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.tasks.solvers.EquationSolver;
import com.tasks.solvers.LinearEquationSolver;
import com.tasks.solvers.QuadraticEquationSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestDrive {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        EquationSolver equationSolver;


        while (flag) {
            System.out.println("Enter type of an equation which you would like to solve: linear/quadratic");
            try {
                String type = br.readLine();
                if ("linear".equalsIgnoreCase(type)) {
                    equationSolver = new LinearEquationSolver();
                    equationSolver.readParametersfromConsole();
                    System.out.println(equationSolver.toString());
                    System.out.println(equationSolver.solve() + "\n");
                    flag = false;
                }

                if ("quadratic".equalsIgnoreCase(type)) {
                    equationSolver = new QuadraticEquationSolver();
                    equationSolver.readParametersfromConsole();
                    System.out.println(equationSolver.toString());
                    System.out.println(equationSolver.solve() + "\n");
                    flag = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
