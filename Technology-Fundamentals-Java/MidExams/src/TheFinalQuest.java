import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> message = Arrays.stream(scanner.nextLine().split(" +")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Stop".equals(line)) {
            String[] allCommands = line.split(" +");
            String command = allCommands[0];

            switch (command) {
                case "Delete":
                    int deleteIndex = Integer.parseInt(allCommands[1]) + 1;
                    if (deleteIndex >= 0 && deleteIndex < message.size()) {
                        message.remove(deleteIndex);
                    }
                    break;
                case "Swap":
                    String word1 = allCommands[1];
                    String word2 = allCommands[2];

                    if (message.contains(word1) && message.contains(word2)) {
                        String swapped = word1;

                        int wordOneIndex = message.indexOf(word1);
                        int wordTwoIndex = message.indexOf(word2);

                        message.set(wordOneIndex, word2);
                        message.set(wordTwoIndex, swapped);
                    }
                    break;
                case "Put":
                    int givenIndex = Integer.parseInt(allCommands[2]); //index= 8, size = 8, lastIndex = 7
                    String word = allCommands[1];
                    if (givenIndex >= 1 && givenIndex <= message.size() + 1) {
                        message.add(givenIndex - 1, word);
                    }
                    break;
                case "Sort":
                    Collections.sort(message, Collections.reverseOrder());
                    break;
                case "Replace":
                    String firstWord = allCommands[1];
                    String secondWord = allCommands[2];
                    if (message.contains(secondWord)) {
                        int secondWordIndex = message.indexOf(secondWord);
                        message.set(secondWordIndex, firstWord);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        for (String s : message) {
            System.out.print(s + " ");
        }
    }
}
