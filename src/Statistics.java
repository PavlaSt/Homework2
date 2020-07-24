import java.util.InputMismatchException;
import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        System.out.println("Program Statistika.");
        System.out.println("-------------------");
        System.out.println("Ze zadaných celých čísel spočítá minimum, maximum a průměr.");
        boolean operationChecker = true;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int countOfNumbers;
            int[] numbers;
            String operation;

//          get input data
            while (true) {
                try {
                    System.out.println("Zadej počet vkládaných hodnot: ");
                    countOfNumbers = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Chybný vstup");
                }
            }
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
            while (operationChecker) {
//          get operation
                while (true) {
                    try {
                        System.out.println("Zadej operaci: MIN, MAX, AVG ");
                        operation = scanner.next();
                        if (operation.equals("MIN") || operation.equals("MAX") || operation.equals("AVG")) {
                            break;
                        } else {
                            System.out.println("Zadej správnou operaci: MIN, MAX nebo AVG.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Chybný vstup.");
                    }
                }

//          perform operation and print result
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
//          decide if continue with different operation
                System.out.println(" Chceš pokračovat další operací operací?  ANO / NE ");
                if (scanner.next().toUpperCase().equals("NE")) {
                    operationChecker = false;
                    break;
                }
            }

//          decide if continue  with different data
            System.out.println("Chceš pokračovat s jinými daty?  ANO / NE ");
            String goOn = scanner.next();

            if (goOn.toUpperCase().equals("NE")) {
                break;
            }
        }
    }
}
