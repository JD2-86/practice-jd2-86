package by.it.shcharbunou.calculator.services.calculator_service;

import by.it.shcharbunou.calculator.exceptions.DivisionByZeroException;
import by.it.shcharbunou.calculator.services.calculator_service.calculator_behavior.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculatorServiceImplTest {

    /*
        single tests - done
        parameterized tests - done
        tests for edge cases - done
        tests for throwing an exception - done
     */

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("testAddDataProvider")
    void testAdd(double expected, double firstParameter, double secondParameter) {
        Assertions.assertEquals(expected, calculatorService.add(firstParameter, secondParameter));
    }

    static Stream<Arguments> testAddDataProvider() {
        return Stream.of(
            Arguments.arguments(10, 5, 5),
            Arguments.arguments(15, 7.5, 7.5),
            Arguments.arguments(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testDivideDataProvider")
    void testDivide(double expected, double firstParameter, double secondParameter) throws DivisionByZeroException {
        Assertions.assertEquals(expected, calculatorService.divide(firstParameter, secondParameter));
    }

    static Stream<Arguments> testDivideDataProvider() {
        return Stream.of(
                Arguments.arguments(5, 25, 5),
                Arguments.arguments(1.5, 3, 2),
                Arguments.arguments(0, 0, 10)
        );
    }

    @Test
    void testDivisionByZeroException() {
        Throwable throwable = Assertions.assertThrows(DivisionByZeroException.class, () -> {
            calculatorService.divide(5, 0);
        });
        Assertions.assertNotNull(throwable.getMessage());
    }

    @Test
    void testSubtract() {
        Assertions.assertEquals(0, calculatorService.subtract(100, 100));
        Assertions.assertEquals(300, calculatorService.subtract(100, -200));
        Assertions.assertEquals(55.55, calculatorService.subtract(105.60, 50.050));
    }

    @Test
    void testMultiply() {
        // edge case
        Assertions.assertEquals(0.010000000000000002, calculatorService.multiply(0.1, 0.1));
        Assertions.assertEquals(100, calculatorService.multiply(50, 2));
        // edge case
        Assertions.assertEquals(0.05, calculatorService.multiply(0.1, 0.5));
        // edge case
        Assertions.assertEquals(0.0005, calculatorService.multiply(0.1, 0.005));
    }
}