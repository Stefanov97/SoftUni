package mortalEngines.entities;

import mortalEngines.entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200;
    private static final double attackPointsModifier = 50;
    private static final double defensePointsModifier = 25;
    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defencePoints) {
        super(name, attackPoints + attackPointsModifier, defencePoints - defensePointsModifier, INITIAL_HEALTH_POINTS);
        this.aggressiveMode = true;

    }


    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.aggressiveMode = true) {
            this.aggressiveMode = false;
            this.setAttackPoints(this.getAttackPoints() - attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints() + defensePointsModifier);
        } else {
            this.aggressiveMode = true;
            this.setAttackPoints(this.getAttackPoints() + attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints() - defensePointsModifier);
        }

    }

    @Override
    public String toString() {
        String mode = "";
        if (this.getAggressiveMode()) {
            mode = "ON";
        } else {
            mode = "OFF";
        }
        return super.toString() + System.lineSeparator() + String.format(" *Aggressive Mode(%s)", mode);
    }
}
