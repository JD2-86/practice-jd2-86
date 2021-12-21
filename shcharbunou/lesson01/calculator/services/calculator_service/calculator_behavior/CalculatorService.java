package by.it.shcharbunou.jd1.jd1_1.homework.jd1_1_2.calculator.services.calculator_service.calculator_behavior;

import by.it.shcharbunou.jd1.jd1_1.homework.jd1_1_2.calculator.exceptions.DivisionByZeroException;

public interface CalculatorService {

    double add(double a, double b);

    double subtract(double a, double b);

    double multiply(double a, double b);

    double divide(double a, double b) throws DivisionByZeroException;
}
