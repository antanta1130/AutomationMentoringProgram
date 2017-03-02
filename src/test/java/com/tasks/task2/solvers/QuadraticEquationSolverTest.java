package com.tasks.task2.solvers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QuadraticEquationSolverTest {
    private EquationSolver quadraticEquationSolver1 = new QuadraticEquationSolver(8, -77, 4);
    private EquationSolver quadraticEquationSolver2 = new QuadraticEquationSolver(0, 77, 4);
    private EquationSolver quadraticEquationSolver3 = new QuadraticEquationSolver(8, 1, 4);
    private EquationSolver quadraticEquationSolver4 = new QuadraticEquationSolver();

    @Test
    public void testSolve() {
        Assert.assertEquals("Roots of a quadratic equation are: x1 = 9.573; x2 = 0.052", quadraticEquationSolver1.solve());
    }

    @Test
    public void testSolveWithDivisionByZeroCase() {
        Assert.assertEquals("It is not a quadratic equation", quadraticEquationSolver2.solve());
    }

    @Test
    public void testSolveWithDiscriminantLessThanZero() {
        Assert.assertEquals("There are no real roots, discriminant = -127.0", quadraticEquationSolver3.solve());
    }

    @Test
    public void testSolveWithConstructingObjectUsingDefaultConstructor() {
        Assert.assertEquals("It is not a quadratic equation", quadraticEquationSolver4.solve());
    }

}
