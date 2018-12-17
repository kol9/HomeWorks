package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public class Multiply extends BinaryOperation {
    public Multiply(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    public int operation(int first, int second) {
        return first * second;
    }
}
