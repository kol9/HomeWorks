package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public class Multiply extends BinaryOperation {
    Multiply(AnyExpression first, AnyExpression second) {
        super(first, second);
    }

    public int operation(int first, int second) {
        return first * second;
    }


    public double operation(double first, double second) {
        return first * second;
    }
}
