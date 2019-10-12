import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String output = "";

        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String toAdd = tokens[1];
                    output += toAdd;
                    break;
                case "Upgrade": {
                    String letter = tokens[1];
                    char let = letter.charAt(0);
                    int newLetterCode = ((int) let) + 1;
                    char newLetterChar = (char) newLetterCode;
                    String newLetter = String.valueOf(newLetterChar);
                    output = output.replace(letter, newLetter);
                    break;
                }
                case "Print":
                    System.out.println(output);
                    break;
                case "Index":
                    String thatLetter = tokens[1];
                    char letter = tokens[1].charAt(0);
                    if (output.contains(thatLetter)) {
                        for (int i = 0; i < output.length(); i++) {
                            if (letter == output.charAt(i)) {
                                System.out.print(i + " ");
                            }
                        }
                    } else {
                        System.out.println("None");
                    }
                    System.out.println();
                    break;
                case "Remove":
                    String toRemove = tokens[1];
                    output = output.replace(toRemove, "");

                    break;
            }
            line = scanner.nextLine();
        }
    }
}
