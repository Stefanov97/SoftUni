package boatRacingSimulator.models.boats;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.helpers.Validator;
import boatRacingSimulator.models.races.Race;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, int weight, int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) throws ArgumentException {
        if (Validator.validatePositiveParam(oars)) {
            this.oars = oars;
        } else {
            throw new ArgumentException(Validator.generateArgumentExceptionMessage("Oars"));
        }
    }

    public int getOars() {
        return this.oars;
    }

    @Override
    public double getOutput(Race race) {
        return (this.getOars() * 100) - this.getWeight() + race.getOceanCurrentSpeed();
    }
}
