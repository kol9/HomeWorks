package expression;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public abstract class UnaryOperation implements TripleExpression {
    private TripleExpression operand;

    UnaryOperation(TripleExpression x) {
        operand = x;
    }

    abstract int operation(final int x);

    public int evaluate(int x, int y, int z) {
        return operation(operand.evaluate(x, y, z));
    }

}
