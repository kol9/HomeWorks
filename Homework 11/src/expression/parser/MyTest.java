package expression.parser;

import expression.TripleExpression;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class MyTest {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        String s = "1 + 9  + 2";
        TripleExpression ans = parser.parse(s);

        System.out.println(ans.evaluate(1,0,0));

    }
}

