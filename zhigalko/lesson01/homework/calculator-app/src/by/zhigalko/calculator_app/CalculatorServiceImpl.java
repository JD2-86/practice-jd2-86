package by.zhigalko.calculator_app;

import java.util.Scanner;

public class CalculatorServiceImpl implements CalculatorService{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return  a - b;
    }

    @Override
    public double multiply(double a, double b) {
        if(Math.abs(a)==0D || Math.abs(b)==0D){
            return 0D;
        }
        return a * b;
    }

    @Override
    public double divide(double a, double b)  {
        if (b == 0D) {
            try {
                throw new DivisionByZeroException("Division by zero is forbidden!");
            } catch (DivisionByZeroException e) {
                System.out.println(e.getMessage());
            }
        }
        if (a == 0D && b < 0D) {
            return 0D;
        }
        return a / b;
    }

    public void run() {
        CalculatorService calculator = new CalculatorServiceImpl();
        double result = 0D;
        printMenu();
        int operationNumber = getOperationNumber();
        double firstNumber = getNumber(1);
        double secondNumber = getNumber(2);

        switch (operationNumber) {
            case 1:
                result = calculator.add(firstNumber, secondNumber);
                break;
            case 2:
                result = calculator.subtract(firstNumber, secondNumber);
                break;
            case 3:
                result = calculator.multiply(firstNumber, secondNumber);
                break;
            case 4:
                try {
                    result = calculator.divide(firstNumber, secondNumber);
                } catch (DivisionByZeroException e) {
                    e.printStackTrace();
                }
                break;
        }
        if(!(Double.valueOf(result).isInfinite())){
            System.out.println("result = " + result + "\n");
        }
        System.out.println("Do you want to make another operation? (yes/no)");
        getUserAnswer();

    }

    private int getOperationNumber() {
        int operationNumber;
        try {
            String userInput = scanner.nextLine();
            operationNumber = Integer.parseInt(userInput);
            if (operationNumber >= 1 && operationNumber <= 4) {
                return operationNumber;
            } else {
                System.out.println("Invalid choice!");
                return getOperationNumber();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please input a number!");
            return getOperationNumber();
        }
    }

    private double getNumber(int number) {
        if(number==1){
            System.out.println("Please enter the first number: ");
        } else {
            System.out.println("Please enter the second number: ");
        }
        try {
            String userInput = scanner.nextLine();
            return Double.parseDouble(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return getNumber(number);
        }
    }

    private String getUserAnswer(){
        String userAnswer;
        try {
            userAnswer = scanner.next();
            if ("yes".equals(userAnswer)) {
                run();
            } else if ("no".equals(userAnswer)){
                System.exit(0);
            } else {
                System.out.println("Invalid answer! Please check your answer");
                return getUserAnswer();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter the word (yes / no)!");
            return getUserAnswer();
        }
        return userAnswer;
    }

    private void printMenu(){
        System.out.println("Calculator Menu: \n"
                + "1. Addition \n"
                + "2. Subtraction \n"
                + "3. Multiplication \n"
                + "4. Division \n"
                + "What do the operation you need?"
        );
    }
}
