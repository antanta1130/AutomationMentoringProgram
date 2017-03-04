package com.tasks.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.tasks.task2.solvers.EquationSolver;
import com.tasks.task2.solvers.LinearEquationSolver;
import com.tasks.task2.solvers.QuadraticEquationSolver;

public class MyReader {
    private final BufferedReader br;

    public MyReader(Reader in) {
        br = new BufferedReader(in);
    }

    public void readRarametersAndCreateEquation(EquationSolver equationSolver) throws IOException {
        String[] split;
        double[] params = new double[equationSolver.getParamsNumbers()];

        while (true) {
            System.out.println("Enter " + equationSolver.getParamsNumbers() + " double values separated by , in such sequence: " + equationSolver.getParams());

            try {
                String s = br.readLine();
                split = s.split(",");
                for (int i = 0; i < equationSolver.getParamsNumbers(); i++) {
                    params[i] = Double.parseDouble(split[i]);
                }
                equationSolver.initialize(params);
                break;

            } catch (NumberFormatException e) {
            }
        }
    }

    public List<EquationSolver> readRarametersAndCreateListOfEquations(EquationSolver equationSolver) throws IOException {
        List<EquationSolver> listOfEquations = new ArrayList<EquationSolver>();
        String s;

        while ((s = br.readLine()) != null) {
            double[] params = new double[equationSolver.getParamsNumbers()];
            try {
                String[] split = s.split(",");
                for (int i = 0; i < equationSolver.getParamsNumbers(); i++) {
                    params[i] = Double.parseDouble(split[i]);
                }

                switch (equationSolver.getName()) {
                case "linear":
                    LinearEquationSolver linearEquation = new LinearEquationSolver();
                    linearEquation.initialize(params);
                    listOfEquations.add(linearEquation);
                    break;
                case "quadratic":
                    QuadraticEquationSolver quadraticEquation = new QuadraticEquationSolver();
                    quadraticEquation.initialize(params);
                    listOfEquations.add(quadraticEquation);
                    break;
                }

            } catch (NumberFormatException e) {
            }
        }

        return listOfEquations;
    }
}
