import org.junit.jupiter.*

import java.util.stream.Stream;

class CalculatorAppParameterTest {
    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @MethodSource("argProviderAddTest")
    public void testAdd(double result, double a, double b) {
        Assertions.assertEquals(result,calculator.add(a,b));
    }

    static Stream<Arguments> argProviderAddTest() {
        return Stream.of(
                Arguments.arguments(345,135,210),
                Arguments.arguments(-4689,-2000,-2689),
                Arguments.arguments(0,0,0)
        );
    }

    @ParameterizedTest
    @MethodSource("argProviderSubtractTest")
    public void testSubtract(double result, double a, double b) {
        Assertions.assertEquals(result,calculator.subtract(a,b));
    }

    static Stream<Arguments> argProviderSubtractTest() {
        return Stream.of(
                Arguments.arguments(-14.2,20.47,34.67),
                Arguments.arguments(-123,-234,-111),
                Arguments.arguments(0,0,0)
        );
    }

    @ParameterizedTest
    @MethodSource("argProviderMultiplyTest")
    public void testMultiply(double result, double a, double b) {
        Assertions.assertEquals(result,calculator.multiply(a,b));
    }

    static Stream<Arguments> argProviderMultiplyTest() {
        return Stream.of(
                Arguments.arguments(35,10,3.5),
                Arguments.arguments(35,-5,-7),
                Arguments.arguments(27,3,9)
        );
    }

    @ParameterizedTest
    @MethodSource("argProviderDivideTest")
    public void testDivide(double result, double a, double b) {
        try {
            Assertions.assertEquals(result,calculator.divide(a,b));
        } catch (DivisionByZeroException e) {
            e.printStackTrace();
        }
    }

    static Stream<Arguments> argProviderDivideTest() {
        return Stream.of(
                Arguments.arguments(9,81,9),
                Arguments.arguments(37.5,562.5,15),
                Arguments.arguments(0,0,37)
        );
    }

    @ParameterizedTest
    @MethodSource("argProvideDivideExceptionTest")
    public void testDivideException(Class<Throwable> e, double a, double b) {
        Assertions.assertThrows(e,() -> {calculator.divide(a,b);});
    }

    static Stream<Arguments> argProvideDivideExceptionTest() {
        return Stream.of(
                Arguments.arguments(DivisionByZeroException.class,5,0)
        );
    }
}
