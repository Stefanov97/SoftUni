package models.optics;

public class AluminiumOptic implements Optic {
    private static final int BONUS_POINTS = 1;

    @Override
    public int getBonusPoints() {
        return BONUS_POINTS;
    }
}
