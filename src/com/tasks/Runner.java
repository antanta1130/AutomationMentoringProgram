package com.tasks;

import com.tasks.solvers.EquationSolver;
import com.tasks.solvers.LinearEquationSolver;
import com.tasks.solvers.QuadraticEquationSolver;

public class Runner {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        EquationSolver quadraticEquationSolver = new QuadraticEquationSolver(8, 77, 4);
        System.out.println(quadraticEquationSolver.solve());
    }

    public static void task2() {
        EquationSolver linearEquationSolver = new LinearEquationSolver(3, 8);
        System.out.println(linearEquationSolver.solve());
    }
}
