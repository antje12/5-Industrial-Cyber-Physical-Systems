import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class BasedModel
{
    public static void main(String[] args) {
        Exercise7();
    }

    public static void Example(){
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        /* 1. Defining the variables */
        //Max Profit = 60X + 40Y
        Variable X = model.addVariable("Number of red paint drum").weight(60);
        Variable Y = model.addVariable("Number of white paint drum").weight(40);

        /* 2. Constraints */
        //X + Y ≤ 100
        Expression totalDrums = model.addExpression("Total Drums")
                .upper(100)
                .set(X, 1)
                .set(Y, 1);

        //X ≥ 0
        Expression xPositive = model.addExpression("X positive")
                .lower(0)
                .set(X, 1);

        //Y ≥ 0
        Expression yPositive = model.addExpression("Y positive")
                .lower(0)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }

    public static void Exercise1(){
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable("Number of red paint drum").weight(3);
        Variable Y = model.addVariable("Number of white paint drum").weight(4);

        Expression totalDrums = model.addExpression("Total Drums")
                .upper(14)
                .set(X, 1)
                .set(Y, 2);

        Expression biggerThan0 = model.addExpression("Bigger than, or zero")
                .lower(0)
                .set(X, 3)
                .set(Y, -1);

        Expression lessThan2 = model.addExpression("Less than, or two")
                .upper(2)
                .set(X, 1)
                .set(Y, -1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }

    public static void Exercise2(){
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable("Number of red paint drum").weight(-0.4);
        Variable Y = model.addVariable("Number of white paint drum").weight(3.2);

        Expression max5Red = model.addExpression("Max 5 red")
                .upper(5)
                .set(X, 1);

        Expression totalDrums = model.addExpression("Total Drums")
                .upper(7)
                .set(X, 1)
                .set(Y, 1);

        Expression biggerThan4 = model.addExpression("Bigger than, or four")
                .lower(4)
                .set(X, 1)
                .set(Y, 2);

        // y<=x+5  ===>   y-x<=5
        Expression lessThan5 = model.addExpression("Less than, or five")
                .upper(5)
                .set(X, -1)
                .set(Y, 1);

        Expression xPositive = model.addExpression("X positive")
                .lower(0)
                .set(X, 1);

        Expression yPositive = model.addExpression("Y positive")
                .lower(0)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }

    public static void Exercise3(){
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable("Number of gas").weight(1.9);
        Variable Y = model.addVariable("Number of fuel").weight(1.5);

        Expression total = model.addExpression("Total")
                .lower(0)
                .set(X, 1)
                .set(Y, -2);

        Expression mil6 = model.addExpression("upper X")
                .upper(6.4)
                .set(X, 1);

        Expression mil3 = model.addExpression("lower Y")
                .lower(3.0)
                .set(Y, 1);

        Expression xPositive = model.addExpression("X positive")
                .lower(0)
                .set(X, 1);

        Expression yPositive = model.addExpression("Y positive")
                .lower(0)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }

    public static void Exercise4(){
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable("Number of tables").weight(30).integer(true);
        Variable Y = model.addVariable("Number of chairs").weight(10).integer(true);

        Expression total = model.addExpression("Total")
                .upper(40)
                .set(X, 6)
                .set(Y, 3);

        Expression chair3 = model.addExpression("lower Y")
                .lower(0)
                .set(X, -3)
                .set(Y, 1);

        Expression table4 = model.addExpression("upper X")
                .upper(19)
                .set(X, 4)
                .set(Y, 1);

        Expression xPositive = model.addExpression("X positive")
                .lower(0)
                .set(X, 1);

        Expression yPositive = model.addExpression("Y positive")
                .lower(0)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }

    public static void Exercise5(){
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable("Number of regular").weight(150);
        Variable Y = model.addVariable("Number of premium").weight(175);

        Expression upperGas = model.addExpression("upper gas")
                .upper(77)
                .set(X, 7)
                .set(Y, 11);

        Expression upperHour = model.addExpression("upper hour")
                .upper(80)
                .set(X, 10)
                .set(Y, 8);

        Expression upperX = model.addExpression("upper x")
                .upper(9)
                .set(X, 1);

        Expression upperY = model.addExpression("upper Y")
                .upper(6)
                .set(Y, 1);

        Expression xPositive = model.addExpression("X positive")
                .lower(0)
                .set(X, 1);

        Expression yPositive = model.addExpression("Y positive")
                .lower(0)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }

    public static void Exercise6(){
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable("Number of X").weight(17.166).integer(true);
        Variable Y = model.addVariable("Number of Y").weight(25.866).integer(true);

        Expression upperMachine = model.addExpression("upper machine")
                .upper(2400)
                .set(X, 13)
                .set(Y, 19);

        Expression upperHand = model.addExpression("upper hand")
                .upper(2100)
                .set(X, 20)
                .set(Y, 29);

        Expression xPositive = model.addExpression("X positive")
                .lower(10)
                .set(X, 1);

        Expression yPositive = model.addExpression("Y positive")
                .lower(0)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }

    public static void Exercise7(){
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable("Number of X").weight(1).integer(true);
        Variable Y = model.addVariable("Number of Y").weight(1).integer(true);

        Expression upperMachineA = model.addExpression("upper machine A")
                .upper(2400)
                .set(X, 50)
                .set(Y, 24);

        Expression upperMachineB = model.addExpression("upper machine B")
                .upper(2100)
                .set(X, 30)
                .set(Y, 33);

        Expression xPositive = model.addExpression("X positive")
                .lower(45)
                .set(X, 1);

        Expression yPositive = model.addExpression("Y positive")
                .lower(5)
                .set(Y, 1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }
}
