package footballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Team> teams = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            switch (command) {
                case "Team":
                    try {
                        teams.put(teamName, new Team(teamName));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Add":
                    if (teams.containsKey(teamName)) {
                        String playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        try {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }

                    } else {
                        System.out.println(String.format("Team %s does not exist.", teamName));
                    }
                    break;
                case "Remove":
                    String playerName = tokens[2];
                    teams.get(teamName).removePlayer(playerName);
                    break;
                case "Rating":
                    if (teams.containsKey(teamName)) {
                        double rating = Math.round(teams.get(teamName).getRating());
                        System.out.println(String.format("%s - %.0f", teamName, rating));
                    } else {
                        System.out.println(String.format("Team %s does not exist.", teamName));
                    }
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
