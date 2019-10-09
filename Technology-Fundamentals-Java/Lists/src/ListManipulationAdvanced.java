import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        boolean isChanged = false;
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {

                case "Contains":
                    boolean isThere = list.contains(Integer.valueOf(command[1]));
                    if (isThere) {
                        System.out.print("Yes");
                    } else {
                        System.out.print("No such number");
                    }
                    break;
                case "Print":
                    if (command[1].equals("even")) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) % 2 == 0) {
                                System.out.print(list.get(i) + " ");
                            }
                        }

                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) % 2 != 0) {
                                System.out.print(list.get(i) + " ");
                            }
                        }

                    }
                    break;

                case "Get":
                    int sum = 0;
                    for (int i = 0; i < list.size(); i++) {
                        sum += list.get(i);
                    }
                    System.out.print(sum);
                    break;
                case "Filter":
                    if (command[1].equals("<")) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) < Integer.parseInt(command[2])) {
                                System.out.print(list.get(i) + " ");
                            }
                        }

                    } else if (command[1].equals(">")) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) > Integer.parseInt(command[2])) {
                                System.out.print(list.get(i) + " ");
                            }
                        }

                    } else if (command[1].equals("<=")) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) <= Integer.parseInt(command[2])) {
                                System.out.print(list.get(i) + " ");
                            }
                        }

                    } else if (command[1].equals(">=")) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) >= Integer.parseInt(command[2])) {
                                System.out.print(list.get(i) + " ");
                            }
                        }
                    }

                    break;

            }
            System.out.println();
            input = scanner.nextLine();
        }
        if (isChanged) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }

        }
    }
}
