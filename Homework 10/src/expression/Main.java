package expression;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public class Main {
    public static void main(String[] args) {

        int x = Integer.parseInt(args[0]);
        int answer = new Add(
                new Subtract(
                        new Multiply(
                                new Variable("x"),
                                new Variable("x")),
                        new Multiply(
                                new Variable("x"),
                                new Const(2))
                ),
                new Const(1)
        ).evaluate(x);
        System.out.println(answer);
    }
}
