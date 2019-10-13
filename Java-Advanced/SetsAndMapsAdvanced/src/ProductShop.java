import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        while (!"Revision".equals(line)) {
            String[] tokens = line.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).put(product, price);

            line = scanner.nextLine();
        }
        shops.forEach((shopName, products) -> {
            System.out.printf("%s->", shopName).println();

            products.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f", product, price).println();
            });
        });
    }
}
