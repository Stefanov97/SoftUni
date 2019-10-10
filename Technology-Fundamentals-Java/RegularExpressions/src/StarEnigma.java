import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "[^@\\-!\\.:]*@(?<name>[A-Z][a-z]+)[^@\\-!\\.:]*:(?<population>[\\d]+)[^@\\-!\\.:]*!(?<type>[A-Z])![^@\\-!\\.:]*->(?<soldiers>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String message = "";
            message = decrypt(input, message);
            Matcher matcher = pattern.matcher(message);
            while (matcher.find()) {

                String name = matcher.group("name");
                String type = matcher.group("type");
                if (type.equals("A")) {
                    attacked.add(name);
                } else {
                    destroyed.add(name);
                }
            }
        }
        System.out.printf("Attacked planets: %d%n", attacked.size());
        attacked.stream().sorted((f, s) -> f.compareTo(s)).forEach(planet -> System.out.printf("-> %s%n", planet));


        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        destroyed.stream().sorted((f, s) -> f.compareTo(s)).forEach(planet -> System.out.printf("-> %s%n", planet));

    }

    private static String decrypt(String input, String message) {
        int key = 0;
        String regex = "[sStTaArR]";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            Matcher matcher = pattern.matcher(String.valueOf(letter));
            while (matcher.find()) {
                key++;
            }
        }
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            int newLetterCode = (int) letter - key;
            char newLetter = (char) newLetterCode;
            message += newLetter;
        }


        return message;
    }
}
