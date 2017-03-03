package com.tasks.task2.solvers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QuadraticEquationSolverTest {
    @DataProvider(name = "tests")
    public static Object[][] parametersSet() {
	return new Object[][] {
		{ new QuadraticEquationSolver(8, -77, 4), "Roots of a quadratic equation are: x1 = 9.573; x2 = 0.052" },
		{ new QuadraticEquationSolver(0, 77, 4), "It is not a quadratic equation" },
		{ new QuadraticEquationSolver(8, 1, 4), "There are no real roots, discriminant = -127.0" },
		{ new QuadraticEquationSolver(), "It is not a quadratic equation" } };
    }

    @Test(dataProvider = "tests")
    public void testSolve(EquationSolver equationSolver, String expectedResult) {
	Assert.assertEquals(expectedResult, equationSolver.solve());
    }
}
