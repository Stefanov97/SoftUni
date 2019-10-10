import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[a-z\\d]+[\\._-]?[a-z\\d]+@[a-z]+(-[a-z]+)?\\.[a-z]+(\\.[a-z]+)?";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
