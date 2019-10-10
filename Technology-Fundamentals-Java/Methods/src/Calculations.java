import java.util.Scanner;

public class Calculations {
    static void printResult(String command, int firstNumber, int secondNumber) {
        int result = 0;
        switch (command) {
            case "add":
                result = firstNumber + secondNumber;
                break;
            case "multiply":
                result = firstNumber * secondNumber;
                break;
            case "subtract":
                result = firstNumber - secondNumber;
                break;
            case "divide":
                result = firstNumber / secondNumber;
                break;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        printResult(command, firstNumber, secondNumber);

    }
}
