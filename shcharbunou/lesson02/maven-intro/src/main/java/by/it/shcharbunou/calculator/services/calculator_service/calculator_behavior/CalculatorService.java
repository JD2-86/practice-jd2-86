package by.it.shcharbunou.calculator.services.calculator_service.calculator_behavior;

import by.it.shcharbunou.calculator.exceptions.DivisionByZeroException;

public interface CalculatorService {

    double add(double a, double b);

    double subtract(double a, double b);

    double multiply(double a, double b);

    double divide(double a, double b) throws DivisionByZeroException;
}
