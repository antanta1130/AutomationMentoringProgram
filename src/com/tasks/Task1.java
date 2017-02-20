package com.tasks;

import com.tasks.solvers.EquationSolver;
import com.tasks.solvers.QuadraticEquationSolver;

public class Task1 {
    public static void main(String[] args) {
    	EquationSolver quadraticEquationSolver = new QuadraticEquationSolver(8,77,4);
    	System.out.println(quadraticEquationSolver.solve());   
    }
    
}
