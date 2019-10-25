package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        TrafficLights[] lights = new TrafficLights[tokens.length];
        for (int i = 0; i < lights.length; i++) {
            lights[i] = TrafficLights.valueOf(tokens[i]);
        }
        StringBuilder sb = new StringBuilder();
        TrafficLights[] lightValues = TrafficLights.values();
        while (n-- > 0) {
            for (int i = 0; i < tokens.length; i++) {
                if (lights[i].ordinal() == 2) {
                    lights[i] = TrafficLights.RED;
                } else {
                    lights[i] = lightValues[lights[i].ordinal() + 1];
                }
                sb.append(lights[i] + " ");

            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }
}
