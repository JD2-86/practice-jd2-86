package calculator.application;

import calculator.exceptions.DivisionByZeroException;
import calculator.services.calculator_service.CalculatorServiceImpl;
import calculator.services.calculator_service.calculator_behavior.CalculatorService;
import calculator.services.client_service.ClientService;
import calculator.services.client_service.client_behavior.Client;
import calculator.utils.Messages;

import java.util.Scanner;

public class CalculatorApplication {

    private static final Scanner CLI = new Scanner(System.in);
    private final Client client = new ClientService();
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public void runApplication() {
        System.out.println(Messages.START_MESSAGE.getMessage());
        double firstOperand;
        double secondOperand;
        String operator;
        double answer;
        String clientAnswer;
        boolean isRunning;
        do {
            isRunning = false;
            System.out.println(Messages.INPUT_OPERAND_MESSAGE.getMessage() + "1:");
            firstOperand = client.inputOperand(CLI);
            System.out.println(Messages.INPUT_OPERAND_MESSAGE.getMessage() + "2:");
            secondOperand = client.inputOperand(CLI);
            System.out.println(Messages.INPUT_OPERATOR_MESSAGE.getMessage());
            operator = client.inputOperator(CLI);
            try {
                answer = processData(firstOperand, secondOperand, operator);
            } catch (DivisionByZeroException e) {
                isRunning = true;
                e.printStackTrace();
                continue;
            }
            client.printAnswer(answer);
            System.out.println(Messages.EXIT_MESSAGE.getMessage());
            clientAnswer = client.inputClientAnswer(CLI);
            if (clientAnswer.equalsIgnoreCase("N")) {
                isRunning = true;
            }
        } while (isRunning);
        CLI.close();
    }

    private double processData(double firstOperand, double secondOperand, String operator) throws DivisionByZeroException {
        switch (operator) {
            case "+":
                return calculatorService.add(firstOperand, secondOperand);
            case "-":
                return calculatorService.subtract(firstOperand, secondOperand);
            case "*":
                return calculatorService.multiply(firstOperand, secondOperand);
            case "/":
                return calculatorService.divide(firstOperand, secondOperand);
        }
        System.out.println(Messages.UNKNOWN_ERROR_MESSAGE.getMessage());
        return -1;
    }
}
