import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> paintings = Arrays.stream(scanner.nextLine().split(" +")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String[] allCommands = line.split(" +");
            String main = allCommands[0];

            switch (main) {
                case "Change":
                    String toSet = allCommands[2];
                    String oldPainting = allCommands[1];
                    int oldIndex = paintings.indexOf(oldPainting);
                    if (paintings.contains(oldPainting)) {
                        paintings.set(oldIndex, toSet);
                    }
                    break;
                case "Hide":
                    String paintingToRemove = allCommands[1];
                    if (paintings.contains(paintingToRemove)) {
                        paintings.remove(paintingToRemove);
                    }
                    break;
                case "Switch":
                    String first = allCommands[1];
                    String second = allCommands[2];
                    int firstIndex = paintings.indexOf(first);
                    int secondIndex = paintings.indexOf(second);
                    if (paintings.contains(first) && paintings.contains(second)) {
                        String oldFirst = paintings.get(firstIndex);
                        paintings.set(firstIndex, second);
                        paintings.set(secondIndex, oldFirst);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(allCommands[1]) + 1;
                    String paintingToInsert = allCommands[2];

                    if (index >= 0 && index <= paintings.size()) {
                        paintings.add(index, paintingToInsert);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(paintings);
                    break;
            }
            line = scanner.nextLine();
        }
        for (String painting : paintings) {
            System.out.print(painting + " ");
        }
    }
}