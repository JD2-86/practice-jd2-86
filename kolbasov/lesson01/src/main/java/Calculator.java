public class Calculator implements CalculatorService {

    @Override
    public double add(double a, double b) {
        return a+b;
    }

    @Override
    public double subtract(double a, double b)
    {
        return a-b;
    }

    @Override
    public double multiply(double a, double b)
    {
        return a*b;
    }

    @Override
    public double divide(double a, double b) throws DivisionByZeroException
    {
        if(b==0)
        {
            throw new DivisionByZeroException();
        }
        return a/b;
    }
}
