package models.bows;

import models.optics.AluminiumOptic;
import models.optics.Optic;

public class AluminiumBow extends BaseBow implements SpecialBow {
    private Optic optic;

    public AluminiumBow(String manufacturer, double weight, int strength) {
        super(manufacturer, weight, strength);
        this.optic = new AluminiumOptic();
    }

    @Override
    public int getOptics() {
        return this.optic.getBonusPoints();
    }
}
