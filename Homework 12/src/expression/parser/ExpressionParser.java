package expression.parser;

import expression.*;
import expression.exceptions.*;

import java.util.EnumSet;
import java.util.Set;

import static expression.exceptions.ParsingException.ErrorMessage;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class ExpressionParser implements Parser {

    private String expression;
    private int index = 0;
    private int balance;


    private enum Token {
        ABS, ADD, BEGIN, MIN, MAX,
        DIV, END, LP, MUL, NEGATE,
        NUMBER, RP, SQRT, SUB, VARIABLE
    }

    private Set<Token> operations = EnumSet.of(Token.ADD, Token.MUL, Token.DIV, Token.SUB);

    private Token curToken = Token.BEGIN;

    private int value;
    private String varName;

    private void skipWhiteSpaces() {
        while (index < expression.length() && Character.isWhitespace(expression.charAt(index))) {
            index++;
        }
    }

    private void checkForOperand() throws MissingArgumentException {
        if (operations.contains(curToken)) {
            throw new MissingArgumentException("Expected argument: " + ErrorMessage(expression, index, false));
        } else if (curToken == Token.LP || curToken == Token.BEGIN) {
            throw new MissingArgumentException("Expected argument: " + ErrorMessage(expression, index, false));
        }

    }

    private void checkForOperator() throws MissingOperatorException {
        if (curToken == Token.RP || curToken == Token.VARIABLE || curToken == Token.NUMBER) {
            throw new MissingOperatorException("Missed operator: " + ErrorMessage(expression, index, false));
        }
    }

    private void nextToken() throws ParsingException {
        skipWhiteSpaces();
        if (index >= expression.length()) {
            curToken = Token.END;
            return;
        }

        char ch = expression.charAt(index);
        switch (ch) {
            case '-':
                if (curToken == Token.NUMBER || curToken == Token.VARIABLE || curToken == Token.RP) {
                    checkForOperand();
                    curToken = Token.SUB;
                } else {
                    if (index + 1 >= expression.length()) {
                        throw new MissingArgumentException("Expected argument:" + ErrorMessage(expression, index, false));
                    }
                    curToken = Token.NEGATE;
                }
                break;
            case '+':
                checkForOperand();
                curToken = Token.ADD;
                break;
            case '*':
                checkForOperand();
                curToken = Token.MUL;
                break;
            case '/':
                checkForOperand();
                curToken = Token.DIV;
                break;
            case '(':
                checkForOperator();
                balance++;
                curToken = Token.LP;
                break;
            case ')':
                if (operations.contains(curToken) || curToken == Token.LP) {
                    throw new MissingArgumentException("Expected argument: " + ErrorMessage(expression, index, false));
                }
                balance--;
                if (balance < 0) throw new BracketsException("Wrong brackets sequence");
                curToken = Token.RP;
                break;
            default:
                if (Character.isDigit(ch)) {
                    checkForOperator();
                    int l = index;
                    while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                        index++;
                    }
                    int r = index;
                    if (index == expression.length()) {
                        index++;
                    }
                    value = Integer.parseUnsignedInt(expression.substring(l, r));
                    curToken = Token.NUMBER;
                    index--;
                } else if (ch == 'x' || ch == 'y' || ch == 'z') {
                    varName = String.valueOf(ch);
                    curToken = Token.VARIABLE;
                } else if (index + 2 < expression.length() && expression.substring(index, index + 3).equals("abs")) {
                    curToken = Token.ABS;
                    index += 2;
                } else if (index + 2 < expression.length() && expression.substring(index, index + 3).equals("min")) {
                    curToken = Token.MIN;
                    index += 2;
                } else if (index + 2 < expression.length() && expression.substring(index, index + 3).equals("max")) {
                    curToken = Token.MAX;
                    index += 2;
                } else if (index + 3 < expression.length() && expression.substring(index, index + 4).equals("sqrt")) {
                    curToken = Token.SQRT;
                    index += 3;
                } else {
                    if (index == expression.length() - 1) {
                        throw new UnknownSymbolException("Unknown symbol \'" + expression.charAt(index) + "\' : " + ErrorMessage(expression, index - 1, true));
                    }
                    char nextChar = expression.charAt(++index);

                    if (nextChar == ' ' || index == expression.length() - 1) {
                        throw new UnknownSymbolException("Unknown symbol \'" + expression.charAt(index - 1) + "\' : " + ErrorMessage(expression, index - 1, true));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(expression.charAt(index - 1));
                        while (index < expression.length() - 1 && nextChar != ' ') {
                            sb.append(nextChar);
                            nextChar = expression.charAt(++index);
                        }
                        if(expression.charAt(index) != ' ' ) {
                            sb.append(expression.charAt(index));
                        }
                        throw new UnreservedSequenceException("Unreserved sequence: \"" + sb.toString() + "\"");
                    }
                    //throw new UnknownSymbolException("Wrong input expression");
                }
        }

        index++;
    }

    private TripleExpression unary() throws ParsingException {
        nextToken();
        TripleExpression res;
        switch (curToken) {
            case NUMBER:
                res = new Const(value);
                nextToken();
                break;
            case VARIABLE:
                res = new Variable(varName);
                nextToken();
                break;
            case NEGATE:
                res = new CheckedNegate(unary());
                break;
            case ABS:
                res = new Abs(unary());
                break;
            case SQRT:
                res = new Sqrt(unary());
                break;
            case LP:
                res = minMax();
                nextToken();
                break;
            default:
                return new Const(0);

        }
        return res;
    }

    private TripleExpression mulDiv() throws ParsingException {
        TripleExpression res = unary();
        do {
            switch (curToken) {
                case MUL:
                    res = new CheckedMultiply(res, unary());
                    break;
                case DIV:
                    res = new CheckedDivide(res, unary());
                    break;
                default:
                    return res;
            }
        } while (true);
    }

    private TripleExpression addSub() throws ParsingException {
        TripleExpression res = mulDiv();
        do {
            switch (curToken) {
                case ADD:
                    res = new CheckedAdd(res, mulDiv());
                    break;
                case SUB:
                    res = new CheckedSubtract(res, mulDiv());
                    break;
                default:
                    return res;
            }

        } while (true);
    }

    private TripleExpression minMax() throws ParsingException {
        TripleExpression res = addSub();
        do {
            switch (curToken) {
                case MIN:
                    res = new Min(res, addSub());
                    break;
                case MAX:
                    res = new Max(res, addSub());
                    break;
                default:
                    return res;
            }

        } while (true);
    }


    public TripleExpression parse(String expression) throws ParsingException {
        index = 0;
        this.expression = expression;
        curToken = Token.BEGIN;
        balance = 0;
        return minMax();
    }

}
