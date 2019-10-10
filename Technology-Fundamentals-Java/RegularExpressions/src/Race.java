import java.util.*;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> competitiors = new LinkedHashMap<>();
        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        for (int i = 0; i < participants.size(); i++) {
            competitiors.putIfAbsent(participants.get(i), 0);

        }

        String line = scanner.nextLine();

        while (!"end of race".equals(line)) {
            String nameAndKm = line;
            String name = "";
            name = getName(name, nameAndKm);
            int km = 0;
            km = getKm(km, nameAndKm);

            if (competitiors.containsKey(name)) {
                int oldValue = competitiors.get(name);
                competitiors.put(name, oldValue + km);
            }


            line = scanner.nextLine();
        }
        List<Integer> positions = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            positions.add(i);
        }
        List<String> token = new ArrayList<>();
        token.add("st");
        token.add("nd");
        token.add("rd");
        competitiors.entrySet().stream().sorted((f, s) -> {

            return s.getValue().compareTo(f.getValue());

        }).limit(3).forEach(e -> {

            System.out.printf("%d%s place: %s%n", positions.get(0), token.get(0), e.getKey());
            positions.remove(0);
            token.remove(0);
        });
    }

    private static int getKm(int km, String nameAndKm) {
        for (int i = 0; i < nameAndKm.length(); i++) {
            char letter = nameAndKm.charAt(i);
            if (Character.isDigit(letter)) {
                km += Integer.parseInt(String.valueOf(letter));
            }
        }
        return km;
    }

    private static String getName(String name, String nameAndKm) {
        for (int i = 0; i < nameAndKm.length(); i++) {
            char letter = nameAndKm.charAt(i);
            if (Character.isAlphabetic(letter)) {
                name += letter;
            }
        }
        return name;
    }
}
