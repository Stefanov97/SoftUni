import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([#$%*&])(?<name>[A-Za-z]+)\\1=(?<length>\\d+)!!(?<text>.+)";

        Pattern pattern = Pattern.compile(regex);
        while (true) {
            String input = scanner.nextLine();
            boolean toBreak = false;
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                int length = Integer.parseInt(matcher.group("length"));
                String text = matcher.group("text");
                if (length == text.length()) {
                    String coordinates = "";
                    coordinates = getCoordinates(coordinates, text);
                    System.out.printf("Coordinates found! %s -> %s%n", matcher.group("name"), coordinates);

                    toBreak = true;
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
            if (toBreak) {
                break;
            }
        }
    }

    private static String getCoordinates(String coordinates, String text) {
        for (int i = 0; i < text.length(); i++) {
            int newLetterCode = (int) text.charAt(i) + text.length();
            char letterToAdd = (char) newLetterCode;
            coordinates += letterToAdd;
        }
        return coordinates;
    }
}
