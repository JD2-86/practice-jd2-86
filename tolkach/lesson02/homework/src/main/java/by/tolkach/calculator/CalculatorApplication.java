package calculator;

import calculator.api.CalculatorService;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс реализует взаимодействие с пользователем по средствам командной строки.
 */

public class CalculatorApplication {
    private CalculatorService calculator = new SimpleCalculator();
    private Scanner scanner = new Scanner(System.in);
    public int firstMessage() {
        int answer = 0;
        do {
            System.out.println("Choose action:\n1.Add\n2.Subtract\n3.Multiply\n4.Divide");
            try {
                answer = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Write number!");
            }
        } while (answer < 1 || answer > 4);
        return answer;
    }
    public double getNum1() {
        System.out.println("Write first number");
        return scanner.nextDouble();
    }
    public double getNum2() {
        System.out.println("Write second number");
        return scanner.nextDouble();
    }
    public String getQuestion() {
        System.out.println("Continue? (yes/no)");
        return scanner.next();
    }
    public void getResult(double result) {
        System.out.println("Result = " + result);
    }
    public double action(int answer, double num1, double num2) {
        double result = 0D;
        switch (answer) {
            case 1:
                result = calculator.add(num1, num2);
                break;
            case 2:
                result = calculator.subtract(num1, num2);
                break;
            case 3:
                result = calculator.multiply(num1, num2);
                break;
            case 4:
                try {
                    result = calculator.divide(num1, num2);
                } catch (DivisionByZeroException e) {
                    e.printStackTrace();
                }
                break;
	    default:
		throw new RuntimeException("Wrong option!");	
        }
        return result;
    }
}
