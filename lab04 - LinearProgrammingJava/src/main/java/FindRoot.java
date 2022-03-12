import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BisectionSolver;

public class FindRoot
{
    public static void main(String[] args)
    {
        BisectionSolver solver = new BisectionSolver();
        double result = 0;

        // max eval = how many cycles to run, trying to calculate the right result
        // min & max = the interval wherein to look for the solution
        result = solver.solve(100, new Function(), 1, 10);
        System.out.println("Result of Function(x): " + result);

        result = solver.solve(100, new F(), 1, 10);
        System.out.println("Result of F(x): " + result);

        result = solver.solve(100, new G(), 1, 10);
        System.out.println("Result of G(x): " + result);
    }

    // the function of which we are trying to find the root
    private static class Function implements UnivariateFunction {
        public double value(double x) { return x - 4;}
    }

    // a new function
    private static class F implements UnivariateFunction {
        public double value(double x) { return java.lang.Math.sin(x);}
    }

    // another function
    private static class G implements UnivariateFunction {
        public double value(double x) { return java.lang.Math.pow(x, 3) - 2 * x - 5;}
    }
}
