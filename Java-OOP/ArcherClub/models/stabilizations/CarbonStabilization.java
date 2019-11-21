package models.stabilizations;

public class CarbonStabilization implements Stabilization {
    private static final int BONUS_POINTS = 1;

    @Override
    public int getBonusPoints() {
        return BONUS_POINTS;
    }
}
