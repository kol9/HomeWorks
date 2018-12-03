package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public abstract class BinaryOperation implements AnyExpression {
    private AnyExpression first, second;

    BinaryOperation(AnyExpression first, AnyExpression second) {
        this.first = first;
        this.second = second;
    }

    abstract int operation(int first, int second);
    abstract double operation(double first, double second);

    public int evaluate(int x) {
        return operation(first.evaluate(x), second.evaluate(x));
    }

    public double evaluate(double x) {
        return operation(first.evaluate(x), second.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return operation(first.evaluate(x,y,z), second.evaluate(x,y,z));
    }
}
