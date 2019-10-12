import java.util.Scanner;

public class AnimalSanctuary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String correctFormat = "n:[^;]*;t:[^;]*;c--[a-zA-Z \\s]*";

            if (input.matches(correctFormat)) {
                String[] tokens = input.split(";+");
                String name = tokens[0];
                String type = tokens[1];
                String country = tokens[2];

                int indexOfSub = name.indexOf(":") + 1;
                name = name.substring(indexOfSub);
                type = type.substring(indexOfSub);
                StringBuilder realType = new StringBuilder();
                StringBuilder realName = new StringBuilder();
                realName = getRealName(name, realName);
                realType = getRealName(type, realType);
                sum = getSum(sum, name);
                sum = getSum(sum, type);
                int indexOfCountry = country.lastIndexOf("-");
                country = country.substring(indexOfCountry + 1);
                System.out.printf("%s is a %s from %s%n", realName, realType, country);
            }
        }
        System.out.printf("Total weight of animals: %dKG", sum);
    }

    private static int getSum(int sum, String name) {
        for (int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            if (Character.isDigit(letter)) {
                int digit = Integer.parseInt(String.valueOf(letter));
                sum += digit;
            }
        }
        return sum;
    }

    private static StringBuilder getRealName(String name, StringBuilder realName) {
        for (int j = 0; j < name.length(); j++) {
            char letter = name.charAt(j);
            if (Character.isAlphabetic(letter) || letter == ' ') {
                realName.append(letter);
            }
        }
        return realName;
    }
}
