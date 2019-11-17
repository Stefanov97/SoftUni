package mortalEngines.entities;

import mortalEngines.entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double INITIAL_HEALTH_POINTS = 100;
    private static final double attackPointsModifier = 40;
    private static final double defensePointsModifier = 30;
    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints - attackPointsModifier, defensePoints + defensePointsModifier, INITIAL_HEALTH_POINTS);
        this.defenseMode = true;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.defenseMode = true) {
            this.defenseMode = false;
            this.setDefensePoints(this.getDefensePoints() - defensePointsModifier);
            this.setAttackPoints(this.getAttackPoints() + attackPointsModifier);
        } else {
            this.defenseMode = true;
            this.setDefensePoints(this.getDefensePoints() + defensePointsModifier);
            this.setAttackPoints(this.getAttackPoints() - attackPointsModifier);
        }
    }

    @Override
    public String toString() {
        String mode = "";
        if (this.getDefenseMode()) {
            mode = "ON";
        } else {
            mode = "OFF";
        }
        return super.toString() + System.lineSeparator() + String.format(" *Defense Mode(%s)", mode);
    }
}
