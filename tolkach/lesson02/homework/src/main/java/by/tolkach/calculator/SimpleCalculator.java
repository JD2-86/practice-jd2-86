package calculator;

import calculator.api.CalculatorService;

/**
 * Класс реализует интерфейс CalculatorService.
 * Выполняет простейшие вычисления, такие как сложение, вычетание, умножение, деление.
 */

public class SimpleCalculator implements CalculatorService {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws DivisionByZeroException {
        if (b == 0) throw new DivisionByZeroException();
        return a / b;
    }
}
