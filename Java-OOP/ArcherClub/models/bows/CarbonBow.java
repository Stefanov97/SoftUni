package models.bows;

import models.optics.CarbonOptic;
import models.optics.Optic;
import models.stabilizations.CarbonStabilization;
import models.stabilizations.Stabilization;

public class CarbonBow extends BaseBow implements SpecialBow {
    private Optic optic;
    private Stabilization stabilization;

    public CarbonBow(String manufacturer, double weight, int strength) {
        super(manufacturer, weight, strength);
        this.optic = new CarbonOptic();
        this.stabilization = new CarbonStabilization();
    }

    @Override
    public int getOptics() {
        return this.optic.getBonusPoints();
    }

    public int getStabilization() {
        return this.stabilization.getBonusPoints();
    }
}
