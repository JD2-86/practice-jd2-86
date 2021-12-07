package by.it.shcharbunou.calculator.services.client_service;

import by.it.shcharbunou.calculator.services.client_service.client_behavior.Client;
import by.it.shcharbunou.calculator.utils.ApplicationReservedWords;
import by.it.shcharbunou.calculator.utils.Messages;
import by.it.shcharbunou.calculator.utils.Operators;

import java.util.Scanner;

public class ClientService implements Client {

    @Override
    public double inputOperand(Scanner scanner) {
        boolean isCorrect;
        double operator = 0;
        do {
            isCorrect = true;
            try {
                operator = Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println(Messages.INPUT_OPERAND_ERROR_MESSAGE.getMessage());
                isCorrect = false;
            }
        } while (!isCorrect);
        return operator;
    }

    @Override
    public String inputOperator(Scanner scanner) {
        boolean isCorrect;
        String operand;
        do {
            isCorrect = true;
            operand = scanner.next();
            if (!operand.matches(Operators.OPERATORS_REGEX.getOperators())) {
                isCorrect = false;
                System.out.println(Messages.INPUT_OPERATOR_ERROR_MESSAGE.getMessage());
            }
        } while (!isCorrect);
        return operand;
    }

    @Override
    public void printAnswer(double answer) {
        System.out.println("Answer: " + answer);
    }

    @Override
    public String inputClientAnswer(Scanner scanner) {
        boolean isCorrect;
        String answer;
        do {
            isCorrect = true;
            answer = scanner.next();
            if (!answer.equals(ApplicationReservedWords.Y.getApplicationReservedWord())
                    && !answer.equals(ApplicationReservedWords.N.getApplicationReservedWord())) {
                isCorrect = false;
                System.out.println(Messages.INPUT_CLIENT_ANSWER_ERROR_MESSAGE.getMessage());
            }
        } while (!isCorrect);
        return answer;
    }
}
