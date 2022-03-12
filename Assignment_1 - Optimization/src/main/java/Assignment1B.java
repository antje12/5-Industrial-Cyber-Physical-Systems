import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class Assignment1B {
    public static void main(String[] args)
    {
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        /* 1. Defining the variables + Objective Functions*/
        //
        Variable X = model.addVariable("Cellphone").weight(1).integer(true);
        Variable Y = model.addVariable("Tablet").weight(1).integer(true);

        /* 2. Constraints */

        // 50X + 24Y <= 40*60
        Expression constraint1 = model.addExpression("Constraint 1")
                .upper(40*60)//less equal = upper,
                .set(X, 50)
                .set(Y, 24);


        // 30X + 33Y <= 35*60
        Expression constraint2 = model.addExpression("Constraint 2")
                .upper(35*60)
                .set(X, 30)
                .set(Y, 33);

        //30 + X >=75
        Expression constraint3 = model.addExpression("Constraint 3")
                .lower(75-30)
                .set(X, 1);

        //30 + X >=75
        Expression constraint4 = model.addExpression("Constraint 4")
                .lower(95-90)
                .set(Y, 1);

        //X ≥ 0
        Expression constraint5 = model.addExpression("Constraint 5")
                .lower(0)//
                .set(X, 1);

        //Y ≥ 0
        Expression constraint6 = model.addExpression("Constraint 6")
                .lower(0)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }
}
