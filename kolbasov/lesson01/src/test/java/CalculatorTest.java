import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

class CalculatorTest  {
    Calculator calculator = new Calculator();



    @Test
    void add()
    {
        double actual = calculator.add(2.2,2.2);
        double expected = 4.4;
        assertEquals(expected,actual);

    }

    @Test
    void subtract()
    {
        double actual = calculator.subtract(5.5,2.2);
        double expected = 3.3;
        assertEquals(expected,actual);
    }

    @Test
    void multiply() {

        double actual = calculator.multiply(5.2,2);
        double expected = 10.4;
        assertEquals(expected,actual);
    }


    @Test
    void divide() throws DivisionByZeroException {
        double actual = calculator.divide(5.2,2.2);
        double expected = 2.3636363636363633;
        assertEquals(expected,actual);
        Throwable thrown = assertThrows(DivisionByZeroException.class,()->
        { calculator.divide(5.2,0);
        });


    }

    @ParameterizedTest
    @CsvSource({
            "2.2, 2.2, 4.4",
            "4.5, 6.3, 10.8",
            "3.9, 6.7, 10.6"
    })
    void addDifferent(double a, double b, double result )
    {
        double actual = calculator.add(a,b);
        assertEquals(result,actual);
    }


    @ParameterizedTest
    @CsvSource({
            "2.3, 2.2, 5.06",
            "7.5, 6.3, 47.25",
            "6.3, 2, 12.6"
    })
    void multiplyDifferent(double a, double b, double result )
    {
        double actual = calculator.multiply(a,b);
        assertEquals(result,actual);
    }

    @ParameterizedTest
    @CsvSource({
            "2.2, 2.2, 0.0",
            "99.3, 6.5, 92.8",
            "6.3, 3.9, 2.4"
    })
    void subtractDifferent(double a, double b, double result )
    {
        double actual = calculator.subtract(a,b);
        assertEquals(result,actual);
    }

    @ParameterizedTest
    @CsvSource({
            "2.2, 2.2, 1",
            "7.1, 2, 3.55",
            "6.4, 3.2, 2",
            "0, 3.2, 0"
    })
    void divideDifferent(double a, double b, double result ) throws DivisionByZeroException {
        double actual = calculator.divide(a,b);
        assertEquals(result,actual);
    }
}
