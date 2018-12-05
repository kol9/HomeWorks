package expression;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class RightShift extends BinaryOperation {
    public RightShift(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    int operation(int first, int second) {
        return first >> second;
    }

    double operation(double first, double second) {
        return (int) first >> (int) second;
    }
}
