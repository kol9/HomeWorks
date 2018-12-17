package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public abstract class BinaryOperation implements TripleExpression {
    private TripleExpression first;
    private TripleExpression second;


    BinaryOperation(TripleExpression first, TripleExpression second) {
        this.first = first;
        this.second = second;
    }

    abstract int operation(int first, int second);

    public int evaluate(int x, int y, int z) {
        return operation(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }
}
