import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class Assignment1A {
    public static void main(String[] args)
    {
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        /* 1. Defining the variables + Objective Functions*/
        //
        Variable X = model.addVariable("Notebook").weight(750).integer(true);
        Variable Y = model.addVariable("Desktop").weight(1000).integer(true);

        /* 2. Constraints */

        // X+Y <= 10000
        Expression constraint1 = model.addExpression("Constraint 1")
                .upper(10000)//less equal = upper,
                .set(X, 1)
                .set(Y, 1);


        // X+2Y <= 15_000
        Expression constraint2 = model.addExpression("Constraint 2")
                .upper(15000)
                .set(X, 1)
                .set(Y, 2);

        //4X+3Y <= 25000
        Expression constraint3 = model.addExpression("Constraint 3")
                .upper(25000)
                .set(X, 4)
                .set(Y, 3);

        //X ≥ 0
        Expression constraint4 = model.addExpression("Constraint 4")
                .lower(0)//
                .set(X, 1);

        //Y ≥ 0
        Expression constraint5 = model.addExpression("Constraint 5")
                .lower(0)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }
}
