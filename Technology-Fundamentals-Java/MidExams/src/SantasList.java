import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> santaList = Arrays.stream(scanner.nextLine().split("&+")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Finished!".equals(line)) {
            String[] allCommands = line.split(" +");
            String command = allCommands[0];
            String firstkidName = allCommands[1];

            switch (command) {

                case "Bad":
                    if (!santaList.contains(firstkidName)) {
                        santaList.add(0, firstkidName);
                    }
                    break;
                case "Good":
                    if (santaList.contains(firstkidName)) {
                        santaList.remove(firstkidName);
                    }
                    break;
                case "Rename":
                    String newName = allCommands[2];

                    if (santaList.contains(firstkidName)) {
                        int index = santaList.indexOf(firstkidName);
                        santaList.set(index, newName);
                    }
                    break;
                case "Rearrange":
                    if (santaList.contains(firstkidName)) {
                        int position = santaList.indexOf(firstkidName);
                        santaList.remove(position);
                        santaList.add(santaList.size(), firstkidName);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        for (int i = 0; i < santaList.size(); i++) {
            if (i == santaList.size() - 1) {
                System.out.print(santaList.get(i));
            } else {
                System.out.print(santaList.get(i) + ", ");
            }
        }
    }
}
