import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCourseTraining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"course start".equals(line)) {
            String[] tokens = line.split(":");
            String command = tokens[0];
            String firstLesson = tokens[1];

            switch (command) {
                case "Add":
                    if (!schedule.contains(firstLesson)) {
                        schedule.add(firstLesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!schedule.contains(firstLesson) && index >= 0 && index <= schedule.size()) {
                        schedule.add(index, firstLesson);
                    }

                    break;
                case "Remove":
                    if (schedule.contains(firstLesson)) {
                        schedule.remove(firstLesson);
                        if (schedule.contains(firstLesson + "-Exercise")) {
                            schedule.remove(firstLesson + "-Exercise");
                        }
                    }
                    break;
                case "Swap":
                    String secondLesson = tokens[2];
                    if (schedule.contains(firstLesson) && schedule.contains(secondLesson)) {
                        int firstIndex = schedule.indexOf(firstLesson);
                        int secondIndex = schedule.indexOf(secondLesson);
                        schedule.set(firstIndex, secondLesson);
                        schedule.set(secondIndex, firstLesson);

                        if (schedule.contains(firstLesson + "-Exercise")) {
                            int fExInx = schedule.indexOf(firstLesson + "-Exercise");
                            String oldEx = schedule.get(fExInx);
                            schedule.remove(oldEx);
                            int fLessInx = schedule.indexOf(firstLesson);
                            schedule.add(fLessInx + 1, firstLesson + "-Exercise");

                        }
                        if (schedule.contains(secondLesson + "-Exercise")) {

                            int sExInx = schedule.indexOf(secondLesson + "-Exercise");
                            String oldEx = schedule.get(sExInx);
                            schedule.remove(oldEx);
                            int sLessInx = schedule.indexOf(secondLesson);
                            schedule.add(sLessInx + 1, secondLesson + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if (schedule.contains(firstLesson) && !schedule.contains(firstLesson + "-Exercise")) {
                        int indx = schedule.indexOf(firstLesson);
                        schedule.add(indx + 1, firstLesson + "-Exercise");
                    } else if (!schedule.contains(firstLesson)) {
                        schedule.add(firstLesson);
                        schedule.add(firstLesson + "-Exercise");
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.println((i + 1) + "." + schedule.get(i));
        }
    }
}
