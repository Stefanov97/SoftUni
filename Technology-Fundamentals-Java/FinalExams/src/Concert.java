import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Integer> timeOnStage = new LinkedHashMap<>();
        Map<String, List<String>> allMembers = new LinkedHashMap<>();
        int totalTime = 0;
        while (!"start of concert".equals(line)) {
            String[] tokens = line.split("; ");
            String command = tokens[0];
            String band = tokens[1];

            switch (command) {
                case "Add":
                    String[] members = tokens[2].split(", ");
                    for (int i = 0; i < members.length; i++) {
                        allMembers.putIfAbsent(band, new ArrayList<>());
                        if (!allMembers.get(band).contains(members[i])) {
                            allMembers.get(band).add(members[i]);
                        }
                    }
                    break;
                case "Play":
                    int time = Integer.parseInt(tokens[2]);
                    totalTime += time;
                    if (timeOnStage.containsKey(band)) {
                        int oldTime = timeOnStage.get(band);
                        timeOnStage.put(band, time + oldTime);
                    }
                    timeOnStage.putIfAbsent(band, time);

                    break;
            }
            line = scanner.nextLine();
        }
        String bandToPrint = scanner.nextLine();

        System.out.println("Total time: " + totalTime);
        timeOnStage.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().compareTo(f.getValue());
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        });
        System.out.println(bandToPrint);
        allMembers.get(bandToPrint).forEach(member -> {
            System.out.printf("=> %s%n", member);
        });
    }
}
