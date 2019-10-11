import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chat = new ArrayList<>();

        String line = scanner.nextLine();

        while (!"end".equals(line)) {
            String[] tokens = line.split(" +");
            String command = tokens[0];
            String message = tokens[1];

            switch (command) {
                case "Chat":
                    chat.add(message);
                    break;
                case "Delete":
                    if (chat.contains(message)) {
                        chat.remove(message);
                    }
                    break;
                case "Edit":
                    if (chat.contains(message)) {
                        String newMessage = tokens[2];
                        int index = chat.indexOf(message);
                        chat.set(index, newMessage);
                    }
                    break;
                case "Pin":
                    if (chat.contains(message)) {
                        int indexToRemove = chat.indexOf(message);
                        chat.add(message);
                        chat.remove(indexToRemove);
                    }
                    break;
                case "Spam":
                    for (int i = 1; i < tokens.length; i++) {
                        chat.add(tokens[i]);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        for (String s : chat) {
            System.out.println(s);
        }
    }
}
