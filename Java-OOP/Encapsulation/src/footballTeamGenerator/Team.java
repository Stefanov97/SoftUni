package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean isPlayerInTheTeam = false;
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                this.players.remove(player);
                isPlayerInTheTeam = true;
                break;
            }
        }
        if (!isPlayerInTheTeam) {
            System.out.println(String.format("Player %s is not in %s team.", name, this.name));
        }
    }

    public double getRating() {
        double rating = 0;
        for (Player player : this.players) {
            rating += player.overallSkillLevel();
        }
        return rating / this.players.size();
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }
}
