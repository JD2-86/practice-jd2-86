import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) throws DivisionByZeroException {
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        double a, b, result = 0.0;
        char operator;

        System.out.println("Enter first number: ");
        a = scan.nextDouble();
        System.out.println("Enter operator: ");
        operator = scan.next().charAt(0);
        System.out.println("Enter second number: ");
        b = scan.nextDouble();

        switch(operator) {
            case '+':
                result = calc.add(a, b);
                break;
            case '-':
                result = calc.subtract(a, b);
                break;
            case '*':
                result = calc.multiply(a, b);
                break;
            case '/':
                result = calc.divide(a, b);
                break;
            default:
                System.out.println("Try again. Use +, -, *, /.");
        }

        System.out.println(result);
    }
}
