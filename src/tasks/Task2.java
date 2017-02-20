package tasks;

import tasks.solvers.EquationSolver;
import tasks.solvers.LinearEquationSolver;

public class Task2 {
	public static void main(String[] args) {
		EquationSolver linearEquationSolver = new LinearEquationSolver(3,8);
		System.out.println(linearEquationSolver.solve());
	}
}
