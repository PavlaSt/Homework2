import java.util.InputMismatchException;
import java.util.Scanner;

public class StatisticsOOP {

    Scanner scanner = new Scanner(System.in);
    int countOfNumbers;
    double[] numbers;
    String operation;
    static boolean operationChecker = true;
    static boolean checker = true;

    void setCount(int countOfNumbers) {
        this.countOfNumbers = countOfNumbers;
    }

    int scanCount() {
        while (true) {
            try {
                System.out.println("Zadej počet vkládaných hodnot: ");
                countOfNumbers = Integer.parseInt(scanner.next());
                if (countOfNumbers > 0) {
                    return countOfNumbers;
                } else {
                    System.out.println("Počet hodnot musí být větší než 0!");
                }
                //break;
            } catch (NumberFormatException e) {
                System.out.println("Chybný vstup");
            }
        }
    }

    void setArray(double[] numbers) {
        this.numbers = numbers;
    }

    double[] scanArray() {
        numbers = new double[countOfNumbers];
        for (int i = 0; i < countOfNumbers; i++) {
            while (true) {
                try {
                    System.out.printf("Zadej %d. hodnotu:  ", i + 1);
                    numbers[i] = Double.parseDouble(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Chybný vstup");
                }
            }
        }
        return numbers;
    }

    void setOperation(String operation) {
        this.operation = operation;
    }

    String scanOperation() {
        while (true) {
            System.out.println("Zadej operaci: MIN, MAX, AVG ");
            operation = scanner.next();
            if (operation.equals("MIN") || operation.equals("MAX") || operation.equals("AVG")) {
                return operation;
                //break;
            } else {
                System.out.println("Zadej správnou operaci: MIN, MAX nebo AVG.");
            }
        }
    }

    double count() {
        switch (operation) {
            case "MIN":
                double min = Double.MAX_VALUE;
                for (int i = 0; i < countOfNumbers; i++) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                    }
                }
                return min;
            case "MAX":
                double max = Double.MIN_VALUE;
                for (int i = 0; i < countOfNumbers; i++) {
                    if (numbers[i] > max) {
                        max = numbers[i];
                    }
                }
                return max;
            case "AVG":
                double sum = 0;
                for (int i = 0; i < countOfNumbers; i++) {
                    sum += numbers[i];
                }
                return sum / countOfNumbers;
            default:
                System.out.println("Chybný vstup");
                break;
        }
        return 0;
    }
    void printResult(double result) {
        System.out.printf("Výsledek je %.2f. ", result);
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
        } else {
            operationChecker = true;
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
            statistics.setCount(statistics.scanCount());
            statistics.setArray(statistics.scanArray());


            while (operationChecker) {
//          get operation
                statistics.setOperation(statistics.scanOperation());

//          perform operation and print result
                statistics.printResult(statistics.count());

//          decide if continue with different operation
                statistics.decideIfNextOperation();
            }

//          decide if continue  with different data
            statistics.decideIfNewData();

        }
    }
}
