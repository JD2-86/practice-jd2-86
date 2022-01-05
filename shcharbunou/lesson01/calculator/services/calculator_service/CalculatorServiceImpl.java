package calculator.services.calculator_service;

import calculator.exceptions.DivisionByZeroException;
import calculator.services.calculator_service.calculator_behavior.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {
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
        if (b != 0) {
            return a / b;
        }
        throw new DivisionByZeroException("Error: Division by zero.");
    }
}
