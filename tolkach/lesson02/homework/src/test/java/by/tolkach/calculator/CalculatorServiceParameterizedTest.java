package calculator;

import calculator.api.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Класс для выполнения параметризированных тестов.
 */

public class CalculatorServiceParameterizedTest {
    private CalculatorService calculator = new SimpleCalculator();

    @ParameterizedTest
    @MethodSource("numProviderForAdd")
    public void add(double result, double num1, double num2) {
        Assertions.assertEquals(result,calculator.add(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("numProviderForSubtract")
    public void subtract(double result, double num1, double num2) {
        Assertions.assertEquals(result,calculator.subtract(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("numProviderForMultiply")
    public void multiply(double result, double num1, double num2) {
        Assertions.assertEquals(result,calculator.multiply(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("numProviderForDivide")
    public void divide(double result, double num1, double num2) {
        try {
            Assertions.assertEquals(result,calculator.divide(num1,num2));
        } catch (DivisionByZeroException e) {
            e.printStackTrace();
        }
    }
    @ParameterizedTest
    @MethodSource("numProviderForDivideException")
    public void divideException(Class<Throwable> e, double num1, double num2) {
        Assertions.assertThrows(e,() -> {calculator.divide(num1,num2);});
    }

    static Stream<Arguments> numProviderForAdd() {
        return Stream.of(
                Arguments.arguments(6,2,4),
                Arguments.arguments(0,-2,2),
                Arguments.arguments(22,6,16)
        );
    }
    static Stream<Arguments> numProviderForSubtract() {
        return Stream.of(
                Arguments.arguments(-2,2,4),
                Arguments.arguments(10,100,90),
                Arguments.arguments(25,70,45)
        );
    }
    static Stream<Arguments> numProviderForMultiply() {
        return Stream.of(
                Arguments.arguments(22,2,11),
                Arguments.arguments(100,100,1),
                Arguments.arguments(40,5,8)
        );
    }
    static Stream<Arguments> numProviderForDivide() {
        return Stream.of(
                Arguments.arguments(5,15,3),
                Arguments.arguments(3,21,7),
                Arguments.arguments(22,44,2)
        );
    }
    static Stream<Arguments> numProviderForDivideException() {
        return Stream.of(
                Arguments.arguments(DivisionByZeroException.class,15,0)
        );
    }
}
