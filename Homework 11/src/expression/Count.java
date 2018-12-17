package expression;


/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class Count extends UnaryOperation{

    public Count(TripleExpression a) {
        super(a);
    }

    int operation(int x) {
        return Integer.bitCount(x);
    }

}
