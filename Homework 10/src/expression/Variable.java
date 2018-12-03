package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public class Variable implements AnyExpression {
    private String varName;

    Variable(String varName) {
        this.varName = varName;
    }

    public int evaluate(int x) {
        assert (varName.equals("x") || varName.equals("y") || varName.equals("z"));
        return x;
    }

    public double evaluate(double x) {
        assert (varName.equals("x") || varName.equals("y") || varName.equals("z"));
        return x;
    }

    public int evaluate(int x, int y, int z) {
        assert (varName.equals("x") || varName.equals("y") || varName.equals("z"));
        if (varName.equals("x")) {
            return x;
        }
        if (varName.equals("y")) {
            return y;
        }
        return z;
    }
}
