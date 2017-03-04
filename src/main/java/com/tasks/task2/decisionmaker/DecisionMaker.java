package com.tasks.task2.decisionmaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.tasks.task2.MyReader;
import com.tasks.task2.solvers.EquationSolver;
import com.tasks.task2.solvers.LinearEquationSolver;
import com.tasks.task2.solvers.QuadraticEquationSolver;

public class DecisionMaker {
    private EquationSolver equationSolver;
    private List<EquationSolver> listOfEquationSolver = new ArrayList<EquationSolver>();
    private Reader reader;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MyReader myReader;

    public void readTypeOfEquationFromConsole() {
        String type;

        try {
            while (equationSolver == null) {
                System.out.println("Enter type of an equation which you would like to solve: linear/quadratic");
                type = br.readLine();
                equationSolver = chooseTypeOfEquation(type);
            }

            chooseTypeOfInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private EquationSolver chooseTypeOfEquation(String type) {
        if ("linear".equalsIgnoreCase(type)) {
            return new LinearEquationSolver();
        }

        if ("quadratic".equalsIgnoreCase(type)) {
            return new QuadraticEquationSolver();
        }

        throw new RuntimeException("Unknown eq type");
    }

    private void chooseTypeOfInputStream() throws FileNotFoundException {
        while (true) {
            try {
                System.out.println("Enter the way of getting parameters: console or file name");
                String type = br.readLine();
                if ("console".equalsIgnoreCase(type)) {
                    reader = new InputStreamReader(System.in);
                    myReader = new MyReader(reader);
                    myReader.readRarametersAndCreateEquation(equationSolver);
                    listOfEquationSolver.add(equationSolver);
                } else {
                    reader = new FileReader(new File(type));
                    myReader = new MyReader(reader);
                    listOfEquationSolver = myReader.readRarametersAndCreateListOfEquations(equationSolver);
                }
                break;
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (EquationSolver e : listOfEquationSolver) {
            System.out.println(e.toString());
            System.out.println(e.solve() + "\n");
        }

    }
}
