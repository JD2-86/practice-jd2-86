public interface CalculatorService {
    double add(double a, double b);

    double subtract(double a, double b);

    double multiply(double a, double b);

    double divide(double a, double b) throws DivisionByZeroException;
}
