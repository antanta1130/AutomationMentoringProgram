package com.tasks.task2.solvers;

import java.io.IOException;
import java.io.Reader;

public interface EquationSolver {
    public String solve();

    public void readParameters(Reader reader) throws IOException;
}
