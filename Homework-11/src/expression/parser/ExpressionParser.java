package expression.parser;

import expression.*;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class ExpressionParser implements Parser {

    private String expression;
    private int index = 0;

    private enum Token {
        ADD, AND, DIV, END,
        LEFT_SHIFT, LP, MISTAKE,
        MUL, NOT, NUMBER, OR, RIGHT_SHIFT,
        RP, SUB, VARIABLE, XOR, COUNT, BINARY_NOT
    }

    private Token curToken = Token.MISTAKE;

    private int value;
    private String varName;

    private void skipWhiteSpaces() {
        while (index < expression.length() && Character.isWhitespace(expression.charAt(index))) {
            index++;
        }
    }

    private void nextToken() {
        skipWhiteSpaces();
        if (index >= expression.length()) {
            curToken = Token.END;
            return;
        }

        char ch = expression.charAt(index);
        switch (ch) {
            case '^':
                curToken = Token.XOR;
                break;
            case '&':
                curToken = Token.AND;
                break;
            case '|':
                curToken = Token.OR;
                break;
            case '~':
                curToken = Token.BINARY_NOT;
                break;
            case '-':
                if (curToken == Token.NUMBER || curToken == Token.VARIABLE || curToken == Token.RP) {
                    curToken = Token.SUB;
                } else {
                    curToken = Token.NOT;
                }
                break;
            case '+':
                curToken = Token.ADD;
                break;
            case '*':
                curToken = Token.MUL;
                break;
            case '/':
                curToken = Token.DIV;
                break;
            case '(':
                curToken = Token.LP;
                break;
            case ')':
                curToken = Token.RP;
                break;
            default:
                if (Character.isDigit(ch)) {
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
                } else if (expression.substring(index, index + 2).equals("<<")) {
                    curToken = Token.LEFT_SHIFT;
                    index++;
                } else if (expression.substring(index, index + 2).equals(">>")) {
                    curToken = Token.RIGHT_SHIFT;
                    index++;
                } else if (expression.substring(index, index + 5).equals("count")) {
                    curToken = Token.COUNT;
                    index += 4;
                } else {
                    curToken = Token.MISTAKE;
                }
        }
        index++;
    }

    private TripleExpression unary() {
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
            case NOT:
                res = new Not(unary());
                break;
            case LP:
                res = shifts();
                nextToken();
                break;
            case BINARY_NOT:
                res = new BinaryNot(unary());
                break;
            case COUNT:
                res = new Count(unary());
                break;
            default:
                return new Const(0);

        }
        return res;
    }

    private TripleExpression mulDiv() {
        TripleExpression res = unary();
        do {
            switch (curToken) {
                case MUL:
                    res = new Multiply(res, unary());
                    break;
                case DIV:
                    res = new Divide(res, unary());
                    break;
                default:
                    return res;
            }
        } while (true);
    }

    private TripleExpression addSub() {
        TripleExpression res = mulDiv();
        do {
            switch (curToken) {
                case ADD:
                    res = new Add(res, mulDiv());
                    break;
                case SUB:
                    res = new Subtract(res, mulDiv());
                    break;
                default:
                    return res;
            }

        } while (true);
    }

    private TripleExpression and() {
        TripleExpression res = addSub();
        do {
            switch (curToken) {
                case AND:
                    res = new And(res, addSub());
                    break;
                default:
                    return res;
            }

        } while (true);
    }

    private TripleExpression xor() {
        TripleExpression res = and();
        do {
            switch (curToken) {
                case XOR:
                    res = new Xor(res, and());
                    break;
                default:
                    return res;
            }

        } while (true);
    }

    private TripleExpression or() {
        TripleExpression res = xor();
        do {
            switch (curToken) {
                case OR:
                    res = new Or(res, xor());
                    break;
                default:
                    return res;
            }

        } while (true);
    }


    private TripleExpression shifts() {
        TripleExpression res = or();
        do {
            switch (curToken) {
                case LEFT_SHIFT:
                    res = new LeftShift(res, addSub());
                    break;
                case RIGHT_SHIFT:
                    res = new RightShift(res, addSub());
                    break;
                default:
                    return res;
            }
        } while (true);
    }

    public TripleExpression parse(String expression) {
        index = 0;
        this.expression = expression;
        curToken = Token.MISTAKE;
        return shifts();
    }


}
