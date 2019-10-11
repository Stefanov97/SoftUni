import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FroggySquad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" +")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (true) {
            String[] tokens = line.split(" +");
            String command = tokens[0];
            boolean toStop = false;

            switch (command) {
                case "Join": {
                    String name = tokens[1];
                    names.add(name);
                    break;
                }
                case "Jump": {
                    String name = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index <= names.size()) {
                        names.add(index, name);
                    }
                    break;
                }
                case "Dive":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < names.size()) {
                        names.remove(index);
                    }
                    break;
                case "First":
                    int count = Integer.parseInt(tokens[1]);
                    if (count > names.size()) {
                        for (int i = 0; i < names.size(); i++) {
                            if (i == names.size() - 1) {
                                System.out.print(names.get(i));
                            } else {
                                System.out.print(names.get(i) + " ");
                            }

                        }
                        System.out.println();

                    } else {
                        int indx = 0;
                        while (count > 0) {
                            if (count == 1) {
                                System.out.print(names.get(indx));
                            } else {
                                System.out.print(names.get(indx) + " ");
                            }
                            indx++;
                            count--;
                        }
                        System.out.println();
                    }
                    break;
                case "Last":
                    int secondCount = Integer.parseInt(tokens[1]);
                    if (secondCount > names.size()) {
                        for (int i = 0; i < names.size(); i++) {
                            if (i == names.size() - 1) {
                                System.out.print(names.get(i));
                            } else {
                                System.out.print(names.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else {
                        int indx = names.size() - secondCount;
                        while (secondCount > 0) {
                            if (secondCount == 1) {
                                System.out.print(names.get(indx));
                            } else {
                                System.out.print(names.get(indx) + " ");
                            }
                            indx++;
                            secondCount--;
                        }
                        System.out.println();
                    }
                    break;
                case "Print":
                    toStop = true;
                    String normalOrReversed = tokens[1];
                    System.out.print("Frogs: ");
                    if (normalOrReversed.equals("Normal")) {
                        for (String name : names) {
                            System.out.print(name + " ");
                        }
                    } else {
                        Collections.reverse(names);
                        for (String name : names) {
                            System.out.print(name + " ");
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
