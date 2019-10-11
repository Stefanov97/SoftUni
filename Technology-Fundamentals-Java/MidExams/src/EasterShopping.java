import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shops = Arrays.stream(scanner.nextLine().split(" +")).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] allCommands = scanner.nextLine().split(" +");
            String main = allCommands[0];

            switch (main) {
                case "Include":
                    String shopToInclude = allCommands[1];
                    shops.add(shopToInclude);
                    break;
                case "Visit":
                    String firstOrLast = allCommands[1];
                    int numberOfShops = Integer.parseInt(allCommands[2]);
                    if (shops.size() < numberOfShops) {
                        break;
                    }
                    if (firstOrLast.equals("first")) {
                        for (int j = 0; j < numberOfShops; j++) {
                            shops.remove(0);
                        }
                    } else {
                        for (int j = 0; j < numberOfShops; j++) {
                            shops.remove(shops.size() - 1);
                        }
                    }
                    break;
                case "Prefer":
                    int firstIndex = Integer.parseInt(allCommands[1]);
                    int secondIndex = Integer.parseInt(allCommands[2]);
                    if (firstIndex >= 0 && firstIndex < shops.size() && secondIndex >= 0 && secondIndex < shops.size()) {
                        String shopOne = shops.get(firstIndex);
                        String shopTwo = shops.get(secondIndex);

                        String oldFirst = shopOne;
                        shops.set(firstIndex, shopTwo);
                        shops.set(secondIndex, oldFirst);
                    }
                    break;
                case "Place":
                    String shopToInsert = allCommands[1];
                    int index = Integer.parseInt(allCommands[2]) + 1;
                    if (index >= 0 && index <= shops.size()) {
                        shops.add(index, shopToInsert);
                    }
                    break;
            }
        }
        System.out.println("Shops left:");

        for (String shop : shops) {
            System.out.print(shop + " ");
        }
    }
}
