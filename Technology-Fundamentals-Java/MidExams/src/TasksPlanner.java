import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TasksPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> hours = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();


        while (!"End".equals(line)) {
            String[] tokens = line.split(" +");
            String command = tokens[0];

            switch (command) {
                case "Complete": {
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < hours.size()) {
                        hours.set(index, 0);
                    }
                    break;
                }
                case "Change":
                    int index = Integer.parseInt(tokens[1]);
                    int time = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < hours.size()) {
                        hours.set(index, time);
                    }
                    break;
                case "Drop":
                    int indx = Integer.parseInt(tokens[1]);
                    if (indx >= 0 && indx < hours.size()) {
                        hours.set(indx, -1);
                    }
                    break;
                case "Count":
                    String comparer = tokens[1];
                    if (comparer.equals("Completed")) {
                        int completed = 0;
                        for (Integer hour : hours) {
                            if (hour == 0) {
                                completed++;
                            }
                        }
                        System.out.println(completed);

                    } else if (comparer.equals("Incomplete")) {
                        int incompleted = 0;
                        for (Integer hour : hours) {
                            if (hour > 0) {
                                incompleted++;
                            }
                        }
                        System.out.println(incompleted);
                    } else {
                        int dropped = 0;
                        for (Integer hour : hours) {
                            if (hour < 0) {
                                dropped++;
                            }
                        }
                        System.out.println(dropped);
                    }
                    break;
            }

            line = scanner.nextLine();
        }
        for (Integer hour : hours) {
            if (hour > 0) {
                System.out.print(hour + " ");
            }
        }
    }
}
