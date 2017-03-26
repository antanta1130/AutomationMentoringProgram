package com.tasks.task5;

import java.util.Date;

import org.testng.annotations.Test;

import com.tasks.task2.solvers.EquationSolver;

public class TimeServerTest {
    private final TimeServer timeServer = new TimeServer();

    @Test
    public void testSolve(EquationSolver equationSolver, String expectedResult) {
        Date date = new Date();
        CurrentDateDisplay currentDisplay = new CurrentDateDisplay(timeServer);

        timeServer.setMeasurements(date);
        // Assert.assertEquals(date, equationSolver.solve());
    }
}
