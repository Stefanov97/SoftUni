package boatRacingSimulator.models.boats;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.helpers.Validator;
import boatRacingSimulator.models.boatEngines.BoatEngine;
import boatRacingSimulator.models.races.Race;

public class Yacht extends Boat {
    private BoatEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) throws ArgumentException {
        if (Validator.validatePositiveParam(cargoWeight)) {
            this.cargoWeight = cargoWeight;
        } else {
            throw new ArgumentException(Validator.generateArgumentExceptionMessage("Cargo Weight"));
        }
    }

    @Override
    public double getOutput(Race race) {
        return this.engine.getOutput() - (this.getWeight() + this.cargoWeight) + (race.getOceanCurrentSpeed() / 2.0);
    }
}
