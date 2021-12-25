package calculator;

import calculator.api.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Класс для выполнения простых тестов.
 */

public class CalculatorServiceSimpleTest {
    private CalculatorService calculator = new SimpleCalculator();

    @Test
    public void add() {
        Assertions.assertEquals(20,calculator.add(17,3));
    }
    @Test
    public void subtract() {
        Assertions.assertEquals(35,calculator.subtract(55,20));
    }
    @Test
    public void multiply() {
        Assertions.assertEquals(225,calculator.multiply(15,15));
    }
    @Test
    public void divide() {
        try {
            Assertions.assertEquals(7,calculator.divide(21,3));
        } catch (DivisionByZeroException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void divideException() {
        Assertions.assertThrows(DivisionByZeroException.class,() -> {calculator.divide(21, 0);});
    }
}
