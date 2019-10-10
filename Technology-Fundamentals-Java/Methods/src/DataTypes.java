import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String data = scanner.nextLine();

        findDataType(input, data);
    }

    private static void findDataType(String input, String data) {
        boolean isInt = false;
        boolean isDouble = false;
        int output = 0;
        double outputDouble = 0;
        switch (input) {
            case "int":
                output = Integer.parseInt(data);
                output *= 2;
                isInt = true;
                break;
            case "real":
                outputDouble = Double.parseDouble(data);
                outputDouble *= 1.5;
                isDouble = true;
                break;

        }
        if (isInt) {
            System.out.println(output);
        } else if (isDouble) {
            System.out.printf("%.2f", outputDouble);
        } else {
            System.out.printf("$%s$", data);
        }
    }
}
