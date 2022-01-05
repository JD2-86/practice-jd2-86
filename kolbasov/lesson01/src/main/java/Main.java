import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws DivisionByZeroException {

        int a=0,flag =0;
        double b=0,c=0;
        Calculator calculator =new Calculator();
        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.println("1-add"+"\n"+"2-subtract"+"\n"+"3-multiply"+"\n"+"4-divide");
            a=in.nextInt();
            System.out.print("Input the first number: ");
            b=in.nextDouble();
            System.out.print("\n"+"Input the second number: ");
            c=in.nextDouble();
            switch (a) {
                case (1):
                    System.out.println("Result: "+calculator.add(b, c));
                        break;
                case (2):
                    System.out.println("Result: "+calculator.subtract(b, c));
                    break;
                case (3):
                    System.out.println("Result: "+calculator.multiply(b, c));
                    break;
                case (4):
                    try {
                        System.out.println("Result: " + calculator.divide(b, c));
                    } catch (DivisionByZeroException divisionByZeroException)
                    {
                        System.out.println(divisionByZeroException.Exception());
                    }
                default:
                    System.out.println("Input correct math action!!!");

            }
            System.out.println("Continue y/n ?");
            in.nextLine();
            String str= in.nextLine();
            if(str.equals("n")) break;

        }

    }



}


