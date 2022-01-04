package by.skopinau;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void singleAdditionTest() {
        assertEquals(8.648, calculator.add(6.15, 2.498));
    }

    @Test
    void singleSubtractionTest() {
        assertEquals(11, calculator.subtract(4, -7));
    }

    @Test
    void singleMultiplicationTest() {
        assertEquals(9.165047, calculator.multiply(-5.123, -1.789));
    }

    @Test
    void singleDivisionTest() throws DivisionByZeroException {
        assertEquals(-2.5265017667844525, calculator.divide(7.15, -2.83));
    }

    @ParameterizedTest
    @MethodSource("addDataProvider")
    void addTest(double expected, double a, double b) {
        assertEquals(expected, calculator.add(a, b));
    }

    public static Stream<Arguments> addDataProvider() {
        return Stream.of(
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(1, 0, 1),
                Arguments.arguments(1, 1, 0),
                Arguments.arguments(-1, 0, -1),
                Arguments.arguments(-1, -1, 0),
                Arguments.arguments(-2, -1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("subtractDataProvider")
    void subtractTest(double expected, double a, double b) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    public static Stream<Arguments> subtractDataProvider() {
        return Stream.of(
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(-1, 0, 1),
                Arguments.arguments(1, 1, 0),
                Arguments.arguments(1, 0, -1),
                Arguments.arguments(-1, -1, 0),
                Arguments.arguments(0, -1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyDataProvider")
    void multiplyTest(double expected, double a, double b) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    public static Stream<Arguments> multiplyDataProvider() {
        return Stream.of(
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(0, 0, 1),
                Arguments.arguments(0, 1, 0),
                Arguments.arguments(2, 1, 2),
                Arguments.arguments(-2, -1, 2),
                Arguments.arguments(-2, 1, -2),
                Arguments.arguments(2, -1, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("devideDataProvider")
    void devideTest(double expected, double a, double b) throws DivisionByZeroException {
        assertEquals(expected, calculator.divide(a, b));
    }

    public static Stream<Arguments> devideDataProvider() {
        return Stream.of(
                Arguments.arguments(2, 1, 0.5),
                Arguments.arguments(-2, 1, -0.5),
                Arguments.arguments(-2, -1, 0.5),
                Arguments.arguments(2, -1, -0.5)
        );
    }

    @Test
    void exceptionThrowTest1() {
        assertThrows(DivisionByZeroException.class,
                () -> calculator.divide(3, 0));
    }

    @Test
    void exceptionThrowTest2() {
        assertThrows(DivisionByZeroException.class,
                () -> calculator.divide(-1.0, 0.0));
    }
}