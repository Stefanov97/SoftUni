import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "\\+359([\\s-])2\\1[\\d]{3}\\1[\\d]{4}\\b";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> valid = new ArrayList<>();

        while (matcher.find()) {
            valid.add(matcher.group());
        }
        for (int i = 0; i < valid.size(); i++) {
            if (i == valid.size() - 1) {
                System.out.print(valid.get(i));
            } else {
                System.out.print(valid.get(i) + ", ");
            }

        }
    }
}
