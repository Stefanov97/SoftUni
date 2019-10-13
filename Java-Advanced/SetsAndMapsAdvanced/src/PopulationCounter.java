import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        while (!"report".equals(line)) {
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Integer.parseInt(tokens[2]);
            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);

            line = scanner.nextLine();
        }

        countries.entrySet().stream().sorted((f, s) -> {
            LinkedHashMap<String, Long> firstComparableCountry = f.getValue();
            long firstPopulation = 0;
            for (Map.Entry<String, Long> city : firstComparableCountry.entrySet()) {
                firstPopulation += city.getValue();
            }
            LinkedHashMap<String, Long> secondComparableCountry = s.getValue();
            long secondPopulation = 0;
            for (Map.Entry<String, Long> secondCity : secondComparableCountry.entrySet()) {
                secondPopulation += secondCity.getValue();
            }
            return Long.compare(secondPopulation, firstPopulation);
        }).forEach(country -> {

            LinkedHashMap<String, Long> currentCountry = country.getValue();
            long population = 0;
            for (Map.Entry<String, Long> city : currentCountry.entrySet()) {
                population += city.getValue();
            }
            System.out.println(String.format("%s (total population: %d)", country.getKey(), population));
            currentCountry.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue())).forEach(element -> {
                System.out.println(String.format("=>%s: %d", element.getKey(), element.getValue()));
            });


        });
    }
}
