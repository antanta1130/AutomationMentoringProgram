package com.tasks.task2.solvers;

public interface EquationSolver {
    String solve();

    String getParams();

    void initialize(double[] params);

    int getParamsNumbers();

    String getName();
}
