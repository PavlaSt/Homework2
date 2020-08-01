import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {
        boolean checker = true;
        while (checker) {
            Scanner scanner = new Scanner(System.in);
            int a;
            int b;
            String operator;
//          get variables
            while (true) {
                try {
                    System.out.println("Zadej a: ");
                    a = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Chybný vstup");
                }
            }
            while (true) {
                try {
                    System.out.println("Zadej b: ");
                    b = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Chybný vstup");
                }
            }
            while (true) {
                try {
                    System.out.println("Zadej operator: ");
                    operator = scanner.next();
                    if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                        break;
                    } else {
                        System.out.println("Zadej znovu operátor.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Chybný vstup");
                }
            }

//          perform operation and print result
            switch (operator) {
                case "+":
                    System.out.println(a + b);
                    break;
                case "-":
                    System.out.println(a - b);
                    break;
                case "*":
                    System.out.println(a * b);
                    break;
                case "/":
                    try {
                        System.out.println(a / b);
                        break;
                    } catch (ArithmeticException e) {
                        System.out.println("Nulou dělit nelze! Je nutno zadat jinou hodnotu b nebo jiný operátor.");
                        break;
                    }
                default:
                    System.out.println("Chybný vstup.");
                    break;
            }
//          decide if continue
            System.out.println("Chceš pokračovat ?  ANO / NE ");
            String goOn = scanner.next();

            if (goOn.toUpperCase().equals("NE")) {
                checker = false;
                break;
            }
        }
    }
}
