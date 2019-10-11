import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestJurnal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Retire!".equals(line)) {
            List<String> allCommands = Arrays.stream(line.split(" - ")).collect(Collectors.toList());

            String command = allCommands.get(0);
            String quest = allCommands.get(1);

            switch (command) {
                case "Start":
                    if (!journal.contains(quest)) {
                        journal.add(quest);
                    }
                    break;
                case "Complete":
                    if (journal.contains(quest)) {
                        journal.remove(quest);
                    }
                    break;
                case "Side Quest":
                    String text = allCommands.get(1);
                    String[] splitted = text.split(":");
                    String thisQuest = splitted[0];
                    String sideQuest = splitted[1];
                    if (journal.contains(thisQuest)) {
                        int indexOfSideQuest = journal.indexOf(thisQuest) + 1;
                        if (!journal.contains(sideQuest)) {
                            journal.add(indexOfSideQuest, sideQuest);
                        }
                    }
                    break;
                case "Renew":
                    if (journal.contains(quest)) {
                        int index = journal.indexOf(quest);
                        journal.add(quest);
                        journal.remove(index);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        int counter = 0;
        for (String s : journal) {
            counter++;
            if (counter == journal.size()) {
                System.out.print(s);
            } else {
                System.out.print(s + ", ");
            }
        }
    }
}
