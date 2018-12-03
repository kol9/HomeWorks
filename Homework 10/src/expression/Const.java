package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public class Const implements AnyExpression {
    private Number value;

    Const(Number value) {
        this.value = value;
    }

    public int evaluate(int x) {
        return value.intValue();
    }

    public double evaluate(double x) {
        return value.doubleValue();
    }

    public int evaluate(int x, int y, int z) {
        return value.intValue();
    }

}
