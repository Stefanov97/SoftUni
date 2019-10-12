import java.util.*;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> stores = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("->");
            String command = tokens[0];
            String store = tokens[1];

            switch (command) {
                case "Add":
                    String[] items = tokens[2].split(",");
                    if (items.length == 1) {
                        String item = tokens[2];
                        stores.putIfAbsent(store, new ArrayList<>());
                        if (stores.containsKey(store)) {
                            stores.get(store).add(item);
                        }
                    } else {
                        stores.putIfAbsent(store, new ArrayList<>());
                        for (int i = 0; i < items.length; i++) {
                            String newItem = items[i];
                            stores.get(store).add(newItem);
                        }
                    }

                    break;
                case "Remove":
                    stores.remove(store);
                    break;
            }
            line = scanner.nextLine();
        }
        System.out.println("Stores list:");
        stores.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().size() - f.getValue().size();
            if (result == 0) {
                result = s.getKey().compareTo(f.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().forEach(p -> System.out.printf("<<%s>>%n", p));
        });
    }
}
