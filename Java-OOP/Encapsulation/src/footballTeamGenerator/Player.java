package footballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setShooting(int shooting) {
        validateNumber(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void setPassing(int passing) {
        validateNumber(passing, "Passing");
        this.passing = passing;
    }

    private void setDribble(int dribble) {
        validateNumber(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setSprint(int sprint) {
        validateNumber(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setEndurance(int endurance) {
        validateNumber(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void validateNumber(int endurance, String type) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", type));
        }
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public String getName() {
        return this.name;
    }

    public double overallSkillLevel() {
        return (this.shooting + this.passing + this.dribble + this.sprint + this.endurance) / 5.0;
    }
}
