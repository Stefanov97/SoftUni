import java.util.*;
import java.util.function.DoublePredicate;
import java.util.stream.Collectors;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\|+");
        double budget = Double.parseDouble(scanner.nextLine());
        String text = "";
        for (int i = 0; i < firstInput.length; i++) {
            text += firstInput[i] + "->";
        }
        List<String> input = Arrays.stream(text.split("->")).collect(Collectors.toList());

        List<Double> boughtItems = new ArrayList<>();
        for (int i = 0; i < input.size(); i += 2) {
            double price = Double.parseDouble(input.get(i + 1));
            String type = input.get(i);
            switch (type) {
                case "Clothes":
                    if (price <= 50 && budget >= price) {
                        budget -= price;
                        boughtItems.add(price);
                    }
                    break;
                case "Shoes":
                    if (price <= 35 && budget >= price) {
                        budget -= price;
                        boughtItems.add(price);
                    }
                    break;
                case "Accessories":
                    if (price <= 20.50 && budget >= price) {
                        budget -= price;
                        boughtItems.add(price);
                    }
                    break;
            }
        }
        double oldSum = 0;
        for (int i = 0; i < boughtItems.size(); i++) {
            oldSum += boughtItems.get(i);
            boughtItems.set(i, boughtItems.get(i) + (boughtItems.get(i) * 0.4));
            System.out.printf("%.2f ", boughtItems.get(i));
        }
        System.out.println();
        double sum = 0;
        for (Double item : boughtItems) {
            sum += item;
        }
        double profit = sum - oldSum;
        System.out.printf("Profit: %.2f", profit).println();

        if (budget + sum >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }
}
