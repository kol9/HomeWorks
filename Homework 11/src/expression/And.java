package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public class And extends BinaryOperation {
    public And(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    public int operation(int first, int second) {
        return first & second;
    }
}
