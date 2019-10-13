import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> result = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];
            result.putIfAbsent(continent, new LinkedHashMap<>());
            result.get(continent).putIfAbsent(country, new ArrayList<>());
            result.get(continent).get(country).add(city);

        }
        result.forEach((continent, country) -> {
            System.out.printf("%s:", continent).println();

            country.forEach((cou, cities) -> {
                List<Integer> positions = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    positions.add(i);
                }
                System.out.printf("%s -> ", cou);

                cities.forEach((city) -> {
                    if (cities.size() - 1 == positions.get(0)) {
                        System.out.printf("%s", city);
                        positions.remove(0);

                    } else {
                        System.out.printf("%s, ", city);
                        positions.remove(0);
                    }

                });
                System.out.println();
            });
        });
    }
}
