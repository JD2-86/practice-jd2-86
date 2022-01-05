package calculator;

/**
 * Класс реализует исключение при попытке деления на ноль.
 */

public class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {
        this("Dividing on zero!");
    }

    public DivisionByZeroException(String message) {
        super(message);
    }

    public DivisionByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivisionByZeroException(Throwable cause) {
        super(cause);
    }

    public DivisionByZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
