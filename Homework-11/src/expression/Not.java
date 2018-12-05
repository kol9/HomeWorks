package expression;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class Not extends UnaryOperation {
    public Not(TripleExpression x) {
        super(x);
    }

    int operation(int x) {
        return -x;
    }
}
