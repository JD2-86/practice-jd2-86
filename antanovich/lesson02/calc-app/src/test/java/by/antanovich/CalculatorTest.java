package by.antanovich;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CalculatorTest {

    private Calculator calculator = new Calculator();
 
@Test
public void add() {
    assertEquals(4, calculator.add(2, 2), 0);
    assertEquals(1.42, calculator.add(3.14, -1.72), 0.001);
    assertEquals(5.0/3, calculator.add(2.5/3, 2.5/3), 0.001);
}

@Test
public void subtract() {
    assertEquals(0, calculator.subtract(2, 2), 0);
    assertEquals(4.86, calculator.subtract(3.14, -1.72), 0.001);
    assertEquals(2.0/3, calculator.subtract(1.0/3, -1.0/3), 0.001);
}

@Test
public void multiply() {
    assertEquals(2, calculator.multiply(1, 2), 0);
    assertEquals(-5.4008, calculator.multiply(3.14, -1.72), 0.001);
    assertEquals(0.111, calculator.multiply(1.0/3, 1.0/3), 0.001);
}

@Test
public void divide() {
    assertEquals(2, calculator.divide(4, 2), 0);
    assertEquals(-1.826, calculator.divide(3.14, -1.72), 0.001);
    assertEquals(1, calculator.divide(1.0/3, 1.0/3), 0);
}

@Test
public void divideException() {
    Assertions.assertThrows(ArithmeticException.class, new Executable() {

        @Override
        public void execute() throws Throwable {

            calculator.divide(5, 0);

        }
    });
}

}
