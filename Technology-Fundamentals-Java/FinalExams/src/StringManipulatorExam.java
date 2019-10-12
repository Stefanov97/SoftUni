import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StringManipulatorExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            String[] tokens = line.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Translate":
                    char toBeReplaced = tokens[1].charAt(0);
                    char replacement = tokens[2].charAt(0);
                    String current = text.toString();
                    current = current.replace(toBeReplaced, replacement);
                    text.replace(0, text.length(), "");
                    text.append(current);
                    System.out.println(text);
                    break;
                case "Includes":
                    String toFind = tokens[1];
                    int index = text.indexOf(toFind + "");
                    if (index >= 0) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String startWith = tokens[1];
                    if (text.indexOf(startWith) == 0) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    String currentText = text.toString();
                    currentText = currentText.toLowerCase();
                    text.replace(0, text.length(), "");
                    text.append(currentText);
                    System.out.println(text);
                    break;
                case "FindIndex":
                    char toGetLastIndex = tokens[1].charAt(0);
                    System.out.println(text.lastIndexOf(toGetLastIndex + ""));
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    int lastIndex = count + startIndex;
                    text.replace(startIndex, lastIndex, "");
                    System.out.println(text);

                    break;
            }
            line = scanner.nextLine();
        }
    }
}