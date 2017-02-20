package tasks.solvers;

/*
 * bx + c = 0
 */
public class LinearEquationSolver implements EquationSolver {
    private double b;
    private double c;

    public LinearEquationSolver() {
    }

    public LinearEquationSolver(double b, double c) {
        this.b = b;
        this.c = c;
    }

    public String solve() {
        double x;
        if (b != 0) {
            x = -c / b;
            return "Root of linear equation is: x = " + x;
        } else {
            return "It is not a linear equation";
        }
    }

}
