import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, List<String>> companies = new LinkedHashMap<>();

        while (!"End".equals(line)) {
            String[] tokens = line.split(" -> ");
            String company = tokens[0];
            String employee = tokens[1];

            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<>());
                if (!companies.get(company).contains(employee)) {
                    companies.get(company).add(employee);
                }

            } else {
                if (!companies.get(company).contains(employee)) {
                    companies.get(company).add(employee);
                }
            }


            line = scanner.nextLine();
        }
        companies.entrySet().stream().sorted((f, s) -> f.getKey().compareTo(s.getKey())).forEach(e -> {
            System.out.printf("%s%n", e.getKey());
            e.getValue().forEach(f -> System.out.printf("-- %s%n", f));
        });
    }
}
