package models.optics;

public class CarbonOptic implements Optic {
    private static final int BONUS_POINTS = 2;

    @Override
    public int getBonusPoints() {
        return BONUS_POINTS;
    }
}
