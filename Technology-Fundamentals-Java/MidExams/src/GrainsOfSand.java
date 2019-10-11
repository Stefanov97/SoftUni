import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrainsOfSand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sands = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Mort".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String value = tokens[1];

            switch (command) {
                case "Add":
                    sands.add(Integer.valueOf(value));
                    break;
                case "Remove":
                    if (sands.contains(Integer.valueOf(value))) {
                        sands.remove(Integer.valueOf(value));
                    } else {
                        int index = Integer.parseInt(value);
                        if (index >= 0 && index < sands.size()) {
                            sands.remove(index);
                        }
                    }
                    break;
                case "Replace":
                    String newValue = tokens[2];
                    if (sands.contains(Integer.valueOf(value))) {
                        int thisIndex = sands.indexOf(Integer.valueOf(value));

                        if (thisIndex >= 0 && thisIndex < sands.size()) {
                            sands.set(thisIndex, Integer.valueOf(newValue));
                        }
                    }
                    break;
                case "Increase":
                    int increaseSum = Integer.MIN_VALUE;
                    for (int i = 0; i < sands.size(); i++) {
                        if (sands.get(i) >= Integer.valueOf(value)) {
                            increaseSum = sands.get(i);
                            break;
                        } else {
                            increaseSum = sands.get(sands.size() - 1);
                        }
                    }
                    for (int i = 0; i < sands.size(); i++) {
                        sands.set(i, sands.get(i) + increaseSum);
                    }
                    break;
                case "Collapse":
                    int min = Integer.parseInt(tokens[1]);
                    sands = sands.stream().filter(e -> e >= min).collect(Collectors.toList());
                    break;
            }
            line = scanner.nextLine();
        }
        for (int sand : sands) {
            System.out.print(sand + " ");
        }

    }
}
