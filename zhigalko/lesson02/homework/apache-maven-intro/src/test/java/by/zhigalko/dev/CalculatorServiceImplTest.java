package by.zhigalko.dev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorServiceImplTest {

    private final CalculatorService calculator = new CalculatorServiceImpl();

    @Test
    void addTest() {
        assertEquals(28D,calculator.add(Math.abs(Math.round(-15.56)), Math.round(12.4999)));
    }

    @Test
    void subtractTest() {
        assertEquals(2.89,calculator.subtract(Math.round(4.9999),2.11));
    }

    @Test
    void multiplyTest() {
        assertEquals(89.44425,calculator.multiply(45D,1.98765));
    }

    @Test
    void divideTest() throws DivisionByZeroException {
        assertEquals(22.639800769753226,calculator.divide(45D,1.98765));
    }

    @Test
    void divisionByZeroExceptionTest() {
        assertDoesNotThrow(() -> calculator.divide(-146D, 0D));
    }

    @Test
    void divisionByZeroMessageTest() {
        assertDoesNotThrow(() -> calculator.divide(1132D, 0D), "Division by zero is forbidden!");
    }

}