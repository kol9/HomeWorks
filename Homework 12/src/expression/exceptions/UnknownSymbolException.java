package expression.exceptions;

/**
 * Created by Nikolay Yarlychenko on 10/12/2018
 */
public class UnknownSymbolException extends ParsingException {
    public UnknownSymbolException(String s) {
        super(s);
    }
}
