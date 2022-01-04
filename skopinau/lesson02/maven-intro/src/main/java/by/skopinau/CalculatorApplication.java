package by.skopinau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorApplication {
    public static void main(String[] args) throws IOException, DivisionByZeroException {
        char choice, ignore;

        for (; ; ) {
            do {
                System.out.println("Choose:");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("q. Quit");

                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (choice < '1' | choice > '4' & choice != 'q');

            if (choice == 'q') break;

            System.out.println("\n");

            double a, b, r;
            Calculator calculator = new Calculator();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            switch (choice) {
                case '1':
                    System.out.println("Enter numbers");
                    a = Double.parseDouble(reader.readLine());
                    b = Double.parseDouble(reader.readLine());
                    r = calculator.add(a, b);
                    System.out.println("Result: " + r);
                    break;
                case '2':
                    System.out.println("Enter numbers");
                    a = Double.parseDouble(reader.readLine());
                    b = Double.parseDouble(reader.readLine());
                    r = calculator.subtract(a, b);
                    System.out.println("Result: " + r);
                    break;
                case '3':
                    System.out.println("Enter numbers");
                    a = Double.parseDouble(reader.readLine());
                    b = Double.parseDouble(reader.readLine());
                    r = calculator.multiply(a, b);
                    System.out.println("Result: " + r);
                    break;
                case '4':
                    System.out.println("Enter numbers");
                    a = Double.parseDouble(reader.readLine());
                    b = Double.parseDouble(reader.readLine());
                    r = calculator.divide(a, b);
                    System.out.println("Result: " + r);
                    break;
            }
            System.out.println();
        }
    }
}