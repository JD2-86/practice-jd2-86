package by.it.shcharbunou.calculator.services.client_service.client_behavior;

import java.util.Scanner;

public interface Client {

    double inputOperand(Scanner scanner);
    String inputOperator(Scanner scanner);
    void printAnswer(double answer);
    String inputClientAnswer(Scanner scanner);
}
