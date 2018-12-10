package expression.parser;

import expression.exceptions.EvaluateException;
import expression.TripleExpression;
import expression.exceptions.ParsingException;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class MyTest {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        int x = 5;
        String s = "*2";

        try {
            System.out.println(parser.parse(s).evaluate(0,0,0));
        } catch (EvaluateException e) {
            System.out.println(e.getMessage());
        } catch (ParsingException e) {
            e.printStackTrace();
        }

    }
}

