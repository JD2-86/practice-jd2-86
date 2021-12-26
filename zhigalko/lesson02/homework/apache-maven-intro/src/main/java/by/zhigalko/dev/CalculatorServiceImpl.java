package by.zhigalko.dev;

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
        if (Math.abs(a) == 0D || Math.abs(b) == 0D) {
            return 0D;
        }
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0D) {
            try {
                throw new DivisionByZeroException("Division by zero is forbidden!");
            } catch (DivisionByZeroException e) {
                System.out.println(e.getMessage());
            }
        }
        if (a == 0D && b < 0D) {
            return 0D;
        }
        return a / b;
    }
}
