import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] names = input.split("[,\\s]+");

        Map<String, Map<Integer, Double>> demons = new LinkedHashMap<>();

        for (String name : names) {
            demons.put(name, new LinkedHashMap<>());
        }

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int health = 0;
            health = getHealth(health, name);
            double demage = 0;
            demage = getDemage(demage, name);

            demons.get(name).put(health, demage);

        }
        demons.entrySet().stream().sorted((f, s) -> f.getKey().compareTo(s.getKey())).forEach(d -> {
            System.out.printf("%s - ", d.getKey());
            d.getValue().entrySet().stream().forEach(j -> System.out.printf("%d health, %.2f damage%n", j.getKey(), j.getValue()));
        });


    }

    private static double getDemage(double demage, String name) {
        String regex = "(-?\\+?\\d+\\.?\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        while (matcher.find()) {
            String number = matcher.group();
            demage += Double.parseDouble(number);
        }

        String secReg = "(\\*|\\/)";
        Pattern secPattern = Pattern.compile(secReg);
        Matcher secMatcher = secPattern.matcher(name);
        while (secMatcher.find()) {
            String sign = secMatcher.group();
            if (sign.equals("*")) {
                demage *= 2;
            } else {
                demage /= 2;
            }
        }

        return demage;
    }

    private static int getHealth(int health, String name) {
        String regex = "[^\\d\\+\\-\\*\\/\\.]";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            Matcher matcher = pattern.matcher(String.valueOf(letter));
            while (matcher.find()) {
                int number = (int) letter;
                health += number;
            }

        }


        return health;
    }
}
