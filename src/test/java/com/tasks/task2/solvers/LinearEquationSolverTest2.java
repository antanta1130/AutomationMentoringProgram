package com.tasks.task2.solvers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinearEquationSolverTest2 {
    @DataProvider(name = "tests")
    public static Object[][] parametersSet() {
	return new Object[][] { { new LinearEquationSolver(3, -6), "Root of a linear equation is: x = 2.000" },
		{ new LinearEquationSolver(0, 8), "It is not a linear equation" },
		{ new LinearEquationSolver(), "It is not a linear equation" } };
    }

    @Test(dataProvider = "tests")
    public void testSolve(EquationSolver equationSolver, String expectedResult) {
	Assert.assertEquals(expectedResult, equationSolver.solve());
    }
}
