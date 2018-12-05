package expression.parser;

import expression.TripleExpression;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class MyTest {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        int x = 5;
        String s = "6 & 1 + 2";
        TripleExpression ans = parser.parse(s);

        System.out.println(ans.evaluate(0,0,0));

    }
}
//Testing: 10
//        Testing: x
//        Testing: y
//        Testing: z
//        Testing: x+2
//        Testing: 2-y
//        Testing:   3*  z
//        Testing: x/  -  2
