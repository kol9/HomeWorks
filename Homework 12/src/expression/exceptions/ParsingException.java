package expression.exceptions;

import java.util.StringTokenizer;

/**
 * Created by Nikolay Yarlychenko on 10/12/2018
 */
public class ParsingException extends Exception{
    public ParsingException(String expression) {
        super(expression);
    }

    public static String ErrorMessage(String expression, int index, boolean isSkipped) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < index; i++) {
            sb.append(expression.charAt(i));
        }
        if(expression.charAt(index - 1) == ' '){
            sb.append(" ");
        }
        sb.append("{HERE} ");
        if(!isSkipped) {
            sb.append(expression.charAt(index));
        }
        for(int i = index + 1; i < expression.length(); i++) {
            sb.append(expression.charAt(i));
        }
        return sb.toString();
    }

}
