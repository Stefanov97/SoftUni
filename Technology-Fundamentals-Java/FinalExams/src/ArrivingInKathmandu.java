import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^(?<name>[A-Za-z_\\d!@?#$]+)=(?<length>\\d+)<<(?<text>.+)";
        Pattern pattern = Pattern.compile(regex);

        String line = scanner.nextLine();
        while (!"Last note".equals(line)) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String text = matcher.group("text");
                int length = Integer.parseInt(matcher.group("length"));
                String encryptedName = matcher.group("name");
                String name = "";
                name = getName(name, encryptedName);
                if (text.length() == length) {
                    System.out.printf("Coordinates found! %s -> %s%n", name, text);
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
            line = scanner.nextLine();
        }
    }

    private static String getName(String name, String encryptedName) {
        for (int i = 0; i < encryptedName.length(); i++) {
            char letter = encryptedName.charAt(i);
            if (Character.isLetterOrDigit(letter)) {
                name += letter;
            }
        }
        return name;
    }
}
