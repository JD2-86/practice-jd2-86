package by.zhigalko.dev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorServiceImplParameterizedTest {
    private final CalculatorService calculator = new CalculatorServiceImpl();
    @ParameterizedTest
    @MethodSource("dataProviderAdd")
    void addTest(double expected,double a, double b) {
        assertEquals(expected, calculator.add(a,b));
    }

    static Stream<Arguments> dataProviderAdd() {
        return Stream.of(arguments(25D,10D,15D),
                         arguments(150.56,10.54,140.02),
                         arguments(-22.2,2,-24.2),
                         arguments(1577.9999,Math.round(1561.9999),15.9999),
                         arguments(4.5,Math.abs(Math.round(-1.999123)),2.5));
    }

    @ParameterizedTest
    @MethodSource("dataProviderSubtract")
    void subtractTest(double expected,double a, double b) {
        assertEquals(expected, calculator.subtract(a,b));
    }

    static Stream<Arguments> dataProviderSubtract() {
        return Stream.of(arguments(25D,50D,25D),
                         arguments(15.48,20.5,5.02),
                         arguments(26.2,26.2,0D),
                         arguments(-1.999,-1.999,0),
                         arguments(-159,-156,Math.abs(Math.round(2.7894564646))));
    }

    @ParameterizedTest
    @MethodSource("dataProviderMultiply")
    void multiplyTest(double expected,double a, double b) {
        assertEquals(expected,calculator.multiply(a,b));
    }

    static Stream<Arguments> dataProviderMultiply() {
        return Stream.of(arguments(250D,50D,5D),
                         arguments(-102.5,20.5,-5D),
                         arguments(395.9082,26.2,15.111),
                         arguments(0D,(Math.abs(0D)),-132D),
                         arguments(0D,Math.round(-789.49),(Math.abs(0D))));
    }

    @ParameterizedTest
    @MethodSource("dataProviderDivide")
    void divideTest(double expected,double a, double b) throws DivisionByZeroException {
        assertEquals(expected,calculator.divide(a,b));
    }

    static Stream<Arguments> dataProviderDivide(){
        return Stream.of(arguments(25D,500D,20D),
                         arguments(-4.1,20.5,-5),
                         arguments(0D,0D,150.665),
                         arguments(0D,12.1564*0,Math.abs(-2)),
                         arguments(3D, BigInteger.valueOf(2147483645).subtract(BigInteger.valueOf(2147483600)).doubleValue(),15D));
    }

    @ParameterizedTest
    @MethodSource("dataProviderDivideBYZero")
    void DivideByZeroExceptionTest(double a, double b) {
        assertDoesNotThrow(() -> calculator.divide(a, b));
    }

    @ParameterizedTest
    @MethodSource("dataProviderDivideBYZero")
    void DivideByZeroMessageTest(double a, double b) {
        assertDoesNotThrow(() -> calculator.divide(a, b),"Division by zero is forbidden!");
    }

    static Stream<Arguments> dataProviderDivideBYZero() {
        return Stream.of(arguments(500D, 0D),
                         arguments(16511.1651, 0D),
                         arguments(0D,0D));
    }
}