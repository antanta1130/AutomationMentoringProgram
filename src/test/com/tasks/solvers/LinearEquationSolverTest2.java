package com.tasks.solvers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinearEquationSolverTest2 {
    private EquationSolver linearEquationSolver1 = new LinearEquationSolver(3, 8);
    private EquationSolver linearEquationSolver2 = new LinearEquationSolver(0, 8);
    private EquationSolver linearEquationSolver3 = new LinearEquationSolver();

    @Test
    public void testSolve() {
        Assert.assertEquals("Root of a linear equation is: x = 2.000", linearEquationSolver1.solve());
    }

    @Test
    public void testSolveWithIncorrectParameters() {
        Assert.assertEquals("It is not a linear equation", linearEquationSolver2.solve());
    }

    @Test
    public void testSolveWithConstructingObjectUsingDefaultConstructor() {
        Assert.assertEquals("It is not a linear equation", linearEquationSolver3.solve());
    }

}
