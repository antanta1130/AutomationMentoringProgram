package tasks;

import tasks.solvers.EquationSolver;
import tasks.solvers.QuadraticEquationSolver;

public class Task1 {
    public static void main(String[] args) {
    	EquationSolver quadraticEquationSolver = new QuadraticEquationSolver(8,77,4);
    	System.out.println(quadraticEquationSolver.solve());   
    }
    
}
