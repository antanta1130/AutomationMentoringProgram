package com.tasks.task2;

import com.tasks.task2.solvers.EquationSolver;
import com.tasks.task2.solvers.LinearEquationSolver;
import com.tasks.task2.solvers.QuadraticEquationSolver;

import java.util.ArrayList;
import java.util.List;

public class Tasks {
    public static void task1() {
        List<EquationSolver> task1Cases = new ArrayList<EquationSolver>();
        EquationSolver quadraticEquationSolver1 = new QuadraticEquationSolver(8, -77, 4);
        EquationSolver quadraticEquationSolver2 = new QuadraticEquationSolver(0, 77, 4);
        EquationSolver quadraticEquationSolver3 = new QuadraticEquationSolver(8, 1, 4);
        EquationSolver quadraticEquationSolver4 = new QuadraticEquationSolver();
        EquationSolver quadraticEquationSolver5 = new QuadraticEquationSolver(1, 0, -1);

        task1Cases.add(quadraticEquationSolver1);
        task1Cases.add(quadraticEquationSolver2);
        task1Cases.add(quadraticEquationSolver3);
        task1Cases.add(quadraticEquationSolver4);
        task1Cases.add(quadraticEquationSolver5);

        printResults(task1Cases);
    }

    public static void task2() {
        List<EquationSolver> task2Cases = new ArrayList<EquationSolver>();
        EquationSolver linearEquationSolver1 = new LinearEquationSolver(3, 8);
        EquationSolver linearEquationSolver2 = new LinearEquationSolver(0, 8);
        EquationSolver linearEquationSolver3 = new LinearEquationSolver();

        task2Cases.add(linearEquationSolver1);
        task2Cases.add(linearEquationSolver2);
        task2Cases.add(linearEquationSolver3);

        printResults(task2Cases);
    }

    public static void printResults(List<EquationSolver> cases) {
        for (EquationSolver c : cases) {
            System.out.println(c.toString());
            System.out.println(c.solve() + "\n");
        }
    }
}
