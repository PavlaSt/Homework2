import java.util.InputMismatchException;
import java.util.Scanner;

public class StatisticsOOP {

    Scanner scanner = new Scanner(System.in);
    int countOfNumbers;
    int[] numbers;
    String operation;
    static boolean operationChecker = true;
    static boolean checker = true;

    void setCount() {
        while (true) {
            try {
                System.out.println("Zadej počet vkládaných hodnot: ");
                countOfNumbers = Integer.parseInt(scanner.next());
                if (countOfNumbers > 0) {
                    break;
                } else {
                    System.out.println("Počet hodnot musí být větší než 0!");
                }
                //break;
            } catch (NumberFormatException e) {
                System.out.println("Chybný vstup");
            }
        }
    }

    void setArray() {
        numbers = new int[countOfNumbers];
        for (int i = 0; i < countOfNumbers; i++) {
            while (true) {
                try {
                    System.out.printf("Zadej %d. hodnotu:  ", i + 1);
                    numbers[i] = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Chybný vstup");
                }
            }
        }
    }

    void setOperation() {
        while (true) {
            System.out.println("Zadej operaci: MIN, MAX, AVG ");
            operation = scanner.next();
            if (operation.equals("MIN") || operation.equals("MAX") || operation.equals("AVG")) {
                break;
            } else {
                System.out.println("Zadej správnou operaci: MIN, MAX nebo AVG.");
            }
            /*try {
                System.out.println("Zadej operaci: MIN, MAX, AVG ");
                operation = scanner.next();
                if (operation.equals("MIN") || operation.equals("MAX") || operation.equals("AVG")) {
                    break;
                } else {
                    System.out.println("Zadej správnou operaci: MIN, MAX nebo AVG.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Chybný vstup.");
            }*/
        }
    }

    void countAndPrint() {
        switch (operation) {
            case "MIN":
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < countOfNumbers; i++) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                    }
                }
                System.out.printf("Minimum je %d.", min);
                break;
            case "MAX":
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < countOfNumbers; i++) {
                    if (numbers[i] > max) {
                        max = numbers[i];
                    }
                }
                System.out.printf("Maximum je %d.", max);
                break;
            case "AVG":
                int sum = 0;
                for (int i = 0; i < countOfNumbers; i++) {
                    sum += numbers[i];
                }
                System.out.printf("Průměr je %.2f.", sum / (double) countOfNumbers);
                break;
            default:
                System.out.println("Chybný vstup");
                break;
        }
    }

    void decideIfNextOperation() {
        System.out.println(" Chceš pokračovat další operací operací?  ANO / NE ");
        if (scanner.next().toUpperCase().equals("NE")) {
            operationChecker = false;
            //break;
        }
    }

    void decideIfNewData() {
        System.out.println("Chceš pokračovat s jinými daty?  ANO / NE ");
        String goOn = scanner.next();

        if (goOn.toUpperCase().equals("NE")) {
            checker = false;
        }
    }

    public static void main(String[] args) {
//      print introduction
        System.out.println("Program Statistika.");
        System.out.println("-------------------");
        System.out.println("Ze zadaných celých čísel spočítá minimum, maximum a průměr.");

//      create object
        StatisticsOOP statistics = new StatisticsOOP();

        while (checker) {

//          get input data
            statistics.setCount();
            statistics.setArray();


            while (operationChecker) {
//          get operation
                statistics.setOperation();

//          perform operation and print result
                statistics.countAndPrint();

//          decide if continue with different operation
                statistics.decideIfNextOperation();
            }

//          decide if continue  with different data
            statistics.decideIfNewData();

        }
    }
}
