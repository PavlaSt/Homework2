import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorOOP {
    int a;
    int b;
    String operator;
    static boolean checker = true;
    Scanner scanner = new Scanner(System.in);

    void setA(int a) {
        this.a = a;
    }

    void setB(int b){
        this.b = b;
    }

    int scan(String var) {
        while (true) {
            try {
                System.out.printf("Zadej číslo %s: ", var);
                return Integer.parseInt(scanner.next());
                //break;
            } catch (NumberFormatException e) {
                System.out.println("Chybný vstup");
            }
        }

    }

    void setOperator(String operator) {
        this.operator = operator;
    }

    String scanOperator() {
        while (true) {
            try {
                System.out.println("Zadej operátor: ");
                operator = scanner.next();
                if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                    return operator;
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
            calculator.setA(calculator.scan("a"));
            calculator.setB(calculator.scan("b"));
            calculator.setOperator(calculator.scanOperator());

//          perform operation and print result
            calculator.countAndPrint();

//          decide if continue
            calculator.decideIfContinue();

        }
    }
}

