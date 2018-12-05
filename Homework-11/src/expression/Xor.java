package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public class Xor extends BinaryOperation {
    public Xor(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    public int operation(int first, int second) {
        return first ^ second;
    }

    public double operation(double first, double second) {
        return (int) first ^ (int) second;
    }
}
