package com.tasks.task2.decisionmaker;

import com.tasks.task2.solvers.EquationSolver;
import com.tasks.task2.solvers.LinearEquationSolver;
import com.tasks.task2.solvers.QuadraticEquationSolver;

public class DecisionMaker {
    EquationSolver equationSolver;

    public static EquationSolver chooseTypeOfEquation(String type) {
        if ("linear".equalsIgnoreCase(type)) {
            return new LinearEquationSolver();
        }

        if ("quadratic".equalsIgnoreCase(type)) {
            return new QuadraticEquationSolver();
        }

        return null;
    }
}
