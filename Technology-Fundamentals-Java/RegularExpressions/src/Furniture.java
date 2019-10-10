import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<item>[A-Za-z]+)<<(?<price>[\\d\\d.]+)!(?<quantity>\\d+)\\b";
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);

        List<String> bought = new ArrayList<>();
        double totalPrice = 0;

        while (!"Purchase".equals(line)) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String item = matcher.group("item");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                bought.add(item);
                totalPrice += price * quantity;

            }
            line = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String item : bought) {
            System.out.println(item);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);

    }
}
