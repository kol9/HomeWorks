package expression;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class LeftShift extends BinaryOperation {
    public LeftShift(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    int operation(int first, int second) {
        return first << second;
    }
}
