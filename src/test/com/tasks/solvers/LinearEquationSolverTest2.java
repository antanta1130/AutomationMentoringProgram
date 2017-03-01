package com.tasks.solvers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinearEquationSolverTest2 {
    private LinearEquationSolver equation = new LinearEquationSolver(2, -4);

    @Test
    public void testSolve() {
        Assert.assertEquals("Root of a linear equation is: x = 2.000", equation.solve());
    }

}
