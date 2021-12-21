package by.it.shcharbunou.jd1.jd1_1.homework.jd1_1_2.calculator.exceptions;

public class DivisionByZeroException extends Exception {

    public DivisionByZeroException(String message) {
        super(message);
    }

    public DivisionByZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}
