import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstRegex = "^[\\da-zA-Z]{16}$";
        String secondRegex = "^[\\da-zA-Z]{25}$";
        String[] input = scanner.nextLine().split("&");
        List<String> output = new ArrayList<>();

        Pattern firstPattern = Pattern.compile(firstRegex);
        Pattern secondPattern = Pattern.compile(secondRegex);
        for (int i = 0; i < input.length; i++) {
            Matcher firstMatcher = firstPattern.matcher(input[i]);
            Matcher secondMatcher = secondPattern.matcher(input[i]);
            if (firstMatcher.find()) {
                String currentKey = firstMatcher.group();
                String firstPart = currentKey.substring(0, 4);
                String secondPart = currentKey.substring(4, 8);
                String thirdPart = currentKey.substring(8, 12);
                String fourthPart = currentKey.substring(12);
                String stringWithDashes = (firstPart + "-" + secondPart + "-" + thirdPart + "-" + fourthPart).toUpperCase();
                String finalString = "";
                for (int j = 0; j < stringWithDashes.length(); j++) {
                    char currentLetter = stringWithDashes.charAt(j);
                    if (Character.isDigit(currentLetter)) {
                        int digit = Integer.parseInt(String.valueOf(currentLetter));
                        int newDigit = 9 - digit;
                        finalString += newDigit;

                    } else {
                        finalString += currentLetter;
                    }
                }

                output.add(finalString);
            } else if (secondMatcher.find()) {
                String currentKey = secondMatcher.group();
                String firstPart = currentKey.substring(0, 5);
                String secondPart = currentKey.substring(5, 10);
                String thirdPart = currentKey.substring(10, 15);
                String fourthPart = currentKey.substring(15, 20);
                String fifthPart = currentKey.substring(20);
                String stringWithDashes = (firstPart + "-" + secondPart + "-" + thirdPart + "-" + fourthPart + "-" + fifthPart).toUpperCase();
                String finalString = "";
                for (int j = 0; j < stringWithDashes.length(); j++) {
                    char currentLetter = stringWithDashes.charAt(j);
                    if (Character.isDigit(currentLetter)) {
                        int digit = Integer.parseInt(String.valueOf(currentLetter));
                        int newDigit = 9 - digit;
                        finalString += newDigit;

                    } else {
                        finalString += currentLetter;
                    }

                }
                output.add(finalString);
            }
        }
        System.out.println(String.join(", ", output));
    }
}
