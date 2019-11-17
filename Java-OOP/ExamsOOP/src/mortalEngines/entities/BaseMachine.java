package mortalEngines.entities;

import mortalEngines.entities.interfaces.Machine;
import mortalEngines.entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defencePoints, double healthPoints) {
        this.setName(name);
        this.setAttackPoints(attackPoints);
        this.setDefensePoints(defencePoints);
        this.setHealthPoints(healthPoints);
        this.targets = new ArrayList<>();
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null) {
            throw new NullPointerException("Pilot cannot be null.");
        }
        this.pilot = pilot;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
    }

    @Override
    public void attack(String target) {
        if (target == null || target.trim().isEmpty()) {
            throw new IllegalArgumentException("Attack target cannot be null or empty string");
        }
        this.targets.add(target);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("- %s%n", this.getName()));
        sb.append(String.format(" *Type: %s%n", this.getClass().getSimpleName().replace("Impl", "")));
        sb.append(String.format(" *Health: %.2f%n", this.getHealthPoints()));
        sb.append(String.format(" *Attack: %.2f%n", this.getAttackPoints()));
        sb.append(String.format(" *Defense: %.2f%n", this.getDefensePoints()));
        sb.append(" *Targets: ");
        if (this.getTargets().isEmpty()) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", this.getTargets()));
            sb.append(System.lineSeparator());
        }


        return sb.toString().trim();
    }
}
