import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> contacts = Arrays.stream(scanner.nextLine().split(" +")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (true) {
            String[] tokens = line.split(" +");
            String command = tokens[0];
            boolean toStop = false;

            switch (command) {
                case "Add": {
                    String name = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (!contacts.contains(name)) {
                        contacts.add(name);
                    } else {
                        if (index >= 0 && index <= contacts.size()) {
                            contacts.add(index, name);
                        }
                    }
                }
                break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < contacts.size()) {
                        contacts.remove(index);
                    }
                    break;
                case "Export":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < contacts.size()) {
                        if (count > contacts.size() - (startIndex + 1)) {
                            boolean isZero = true;
                            for (int i = startIndex; i < contacts.size(); i++) {
                                isZero = false;
                                if (i == contacts.size() - 1) {
                                    System.out.print(contacts.get(i));
                                } else {
                                    System.out.print(contacts.get(i) + " ");
                                }
                            }
                            if (!isZero) {
                                System.out.println();
                            }
                        } else {
                            boolean isZero = true;
                            while (count > 0) {
                                isZero = false;
                                if (count == 1) {
                                    System.out.print(contacts.get(startIndex));
                                } else {
                                    System.out.print(contacts.get(startIndex) + " ");
                                }

                                startIndex++;
                                count--;
                            }
                            if (!isZero) {
                                System.out.println();
                            }
                        }
                    }
                    break;
                case "Print":
                    toStop = true;
                    String normalOrReversed = tokens[1];
                    if (!contacts.isEmpty()) {
                        System.out.print("Contacts: ");
                    }

                    if (normalOrReversed.equals("Normal")) {
                        for (String contact : contacts) {
                            System.out.print(contact + " ");
                        }
                    } else {
                        Collections.reverse(contacts);
                        for (String contact : contacts) {
                            System.out.print(contact + " ");
                        }
                    }

                    break;
            }
            if (toStop) {
                break;
            }
            line = scanner.nextLine();
        }
    }
}
