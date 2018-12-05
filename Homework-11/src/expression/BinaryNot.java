package expression;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class BinaryNot extends UnaryOperation{
    public BinaryNot(TripleExpression x) {
        super(x);
    }
    int operation(int x) {
        return ~x;
    }
}
