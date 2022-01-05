package calculator;

/**
 * Main-класс, служит для запуска приложения.
 */

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorApplication application = new CalculatorApplication();
        String question;

        do {
            int answer = application.firstMessage();
            double num1 = application.getNum1();
            double num2 = application.getNum2();
            double result = application.action(answer, num1, num2);
            application.getResult(result);
            question = application.getQuestion();
        } while (question.equals("yes"));
    }
}
