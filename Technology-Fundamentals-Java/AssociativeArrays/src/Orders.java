import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();
        Map<String, List<Double>> products = new LinkedHashMap<>();

        while (!"buy".equals(line)) {
            String[] tokens = line.split(" +");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            double quantity = Double.parseDouble(tokens[2]);

            if (products.containsKey(name)) {
                double currentQuantity = products.get(name).get(0);
                double currentPrice = products.get(name).get(1);

                products.get(name).set(0, currentQuantity + quantity);
                if (currentPrice != price) {
                    products.get(name).set(1, price);
                }
            } else {
                products.put(name, new ArrayList<>());
                products.get(name).add(0, quantity);
                products.get(name).add(1, price);
            }


            line = scanner.nextLine();
        }
        for (Map.Entry<String, List<Double>> entry : products.entrySet()) {
            double totalPrice = entry.getValue().get(0) * entry.getValue().get(1);

            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }

    }
}
