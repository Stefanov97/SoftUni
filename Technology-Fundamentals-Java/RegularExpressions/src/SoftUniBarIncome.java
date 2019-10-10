import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String regex ="^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";
        //String regex ="^%(?<name>[A-Z][a-z]+)%[^|$.%]*<(?<product>\\w+)>[^|$.%]*\\|(?<count>\\d+)\\|[^|$.%]*?(?<price>\\d+\\.*(?:\\d*))\\$$";
        String regex = "^%(?<name>[A-Z][a-z]+)%(?:[^\\|\\$\\.%]+)?<(?<product>\\w+)>(?:[^\\|\\$\\.%]+)?\\|(?<count>\\d+)\\|(?:[^\\|\\$\\.%\\d]+)?(?<price>\\d+\\.?(?:\\d*))\\$$";
        Pattern pattern = Pattern.compile(regex);

        String line = scanner.nextLine();
        double totalIncome = 0;

        while (!"end of shift".equals(line)) {
            String input = line;
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                double price = Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("count"));
                System.out.printf("%s: %s - %.2f%n", matcher.group("name"), matcher.group("product"), price);
                totalIncome += price;
            }


            line = scanner.nextLine();
        }
        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}
