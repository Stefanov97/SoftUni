import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([$%])([A-Z][a-z]{2,})\\1: \\[(\\d+)\\]\\|\\[(\\d+)\\]\\|\\[(\\d+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String message = scanner.nextLine();
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                String tag = matcher.group(2);
                String firstNumber = matcher.group(3);
                String secondNumber = matcher.group(4);
                String thirdNumber = matcher.group(5);
                firstNumber = decrypt(firstNumber);
                secondNumber = decrypt(secondNumber);
                thirdNumber = decrypt(thirdNumber);
                String messageToPrint = firstNumber + secondNumber + thirdNumber;
                System.out.printf("%s: %s%n", tag, messageToPrint);


            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
    private static String decrypt(String firstNumber) {
        String newWord = "";
        newWord += (char) Integer.parseInt(firstNumber);

        return newWord;
    }
}
