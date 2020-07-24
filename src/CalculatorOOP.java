import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorOOP {
    int a;
    int b;
    String operator;
    static boolean checker = true;
    Scanner scanner = new Scanner(System.in);

    void setA() {
        while (true) {
            try {
                System.out.println("Zadej číslo a: ");
                a = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Chybný vstup");
            }
        }
    }

    void setB() {
        while (true) {
            try {
                System.out.println("Zadej číslo b: ");
                b = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Chybný vstup");
            }
        }
    }

    void setOperator() {
        while (true) {
            try {
                System.out.println("Zadej operátor: ");
                operator = scanner.next();
                if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                    break;
                } else {
                    System.out.println("Operátor musí být: +, -, * nebo /.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Chybný vstup");
            }
        }
    }

    void countAndPrint() {
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
                    System.out.printf("%.2f", a / (double) b);
                    break;
                } catch (ArithmeticException e) {
                    System.out.println("Nulou dělit nelze! Je nutno zadat jinou hodnotu b nebo jiný operátor.");
                    break;
                }
            default:
                System.out.println("Chybný vstup");
                break;
        }
    }

    void decideIfContinue() {
        System.out.println("Chceš pokračovat ?  ANO / NE ");
        String goOn = scanner.next();

        if (goOn.toUpperCase().equals("NE")) {
            checker = false;
            //break;
        }
    }

    public static void main(String[] args) {
//      print introduction
        System.out.println("Program Kalkulačka");
        System.out.println();
        System.out.println("Provádí operace s celými čísly (sčítání, odčítání, násobení, dělení");

//      make object
        CalculatorOOP calculator = new CalculatorOOP();

        while (checker) {

//          get variables
            calculator.setA();
            calculator.setB();
            calculator.setOperator();

//          perform operation and print result
            calculator.countAndPrint();

//          decide if continue
            calculator.decideIfContinue();

        }
    }
}

