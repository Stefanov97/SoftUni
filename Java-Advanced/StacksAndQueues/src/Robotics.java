import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesWithFeatures = scanner.nextLine().split(";");
        String[] robots = new String[namesWithFeatures.length];
        String[] processingTime = new String[namesWithFeatures.length];
        int[] workingTime = new int[namesWithFeatures.length];


        for (int i = 0; i < namesWithFeatures.length; i++) {
            String[] tokens = namesWithFeatures[i].split("-");
            String robot = tokens[0];
            String time = tokens[1];
            robots[i] = robot;
            processingTime[i] = time;
        }
        String[] startingTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(startingTime[0]);
        int minutes = Integer.parseInt(startingTime[1]);
        int seconds = Integer.parseInt(startingTime[2]);

        String line = scanner.nextLine();
        ArrayDeque<String> queueProducts = new ArrayDeque<>();
        while (!"End".equals(line)) {
            String product = line;
            queueProducts.offer(product);

            line = scanner.nextLine();
        }

        while (!queueProducts.isEmpty()) {
            seconds++;

            String product = queueProducts.poll();
            String robotName = "";
            boolean isTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if (workingTime[i] == 0) {
                    workingTime[i] = Integer.parseInt(processingTime[i]);
                    robotName = robots[i];
                    isTaken = true;

                    break;
                }
            }
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] > 0) {
                    workingTime[i]--;
                }
            }
            if (isTaken) {
                printRobot(robotName, product, hours, minutes, seconds);
            } else {
                queueProducts.offer(product);
            }
        }
    }

    private static void printRobot(String robotName, String product, int hours, int minutes, int seconds) {
        int totalSecs = hours * 3600 + minutes * 60 + seconds;
        long newHours = (totalSecs / (60 * 60)) % 24;
        long newMinutes = (totalSecs / 60) % 60;
        long newSecs = totalSecs % 60;

        System.out.printf("%s - %s [%02d:%02d:%02d]", robotName, product, newHours, newMinutes, newSecs).println();
    }
}
