import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String line = scanner.nextLine();
        while (!"course start".equals(line)) {
            String[] allCommands = line.split(":");
            String command = allCommands[0];
            String lesson = allCommands[1];

            switch (command) {
                case "Add":
                    if (!schedule.contains(lesson)) {
                        schedule.add(lesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(allCommands[2]);
                    if (!schedule.contains(lesson)) {
                        schedule.add(index, lesson);
                    }
                    break;
                case "Remove":
                    if (schedule.contains(lesson)) {
                        schedule.remove(lesson);
                    }
                    if (schedule.contains(lesson + "-Exercise")) {
                        schedule.remove(lesson + "-Exercise");
                    }
                    break;
                case "Swap":
                    String secondLesson = allCommands[2];
                    int indexOfSecond = schedule.indexOf(secondLesson);
                    String firstLesson = lesson;
                    if (schedule.contains(lesson) && schedule.contains(secondLesson)) {
                        schedule.set(schedule.indexOf(lesson), secondLesson);
                        schedule.set(indexOfSecond, firstLesson);
                        if (schedule.contains(lesson + "-Exercise")) {
                            int indexOfExercise = schedule.indexOf(lesson + "-Exercise");
                            String toAdd = lesson + "-Exercise";
                            schedule.remove(indexOfExercise);
                            schedule.add(schedule.indexOf(lesson) + 1, toAdd);

                        }
                        if (schedule.contains(secondLesson + "-Exercise")) {
                            int indexOfSecondExercise = schedule.indexOf(secondLesson + "-Exercise");
                            String somethingToAdd = secondLesson + "-Exercise";
                            schedule.remove(indexOfSecondExercise);
                            schedule.add(schedule.indexOf(secondLesson) + 1, somethingToAdd);

                        }
                    }
                    break;
                case "Exercise":

                    if (schedule.contains(lesson) && !schedule.contains(lesson + "-Exercise")) {
                        int lessonIndex = schedule.indexOf(lesson);
                        schedule.add(lessonIndex + 1, lesson + "-Exercise");
                    } else if (!schedule.contains(lesson)) {
                        schedule.add(lesson);
                        schedule.add(lesson + "-Exercise");
                    }

                    break;
            }


            line = scanner.nextLine();
        }
        int counter = 1;
        for (String s : schedule) {
            System.out.println(counter + "." + s);
            counter++;
        }

    }
}
