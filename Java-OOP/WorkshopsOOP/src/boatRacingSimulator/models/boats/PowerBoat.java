package boatRacingSimulator.models.boats;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.models.boatEngines.BoatEngine;
import boatRacingSimulator.models.races.Race;

public class PowerBoat extends Boat {
    private BoatEngine primaryEngine;
    private BoatEngine secondaryEngine;

    public PowerBoat(String model, int weight, BoatEngine primaryEngine, BoatEngine secondaryEngine) throws ArgumentException {
        super(model, weight);
        this.primaryEngine = primaryEngine;
        this.secondaryEngine = secondaryEngine;
    }

    @Override
    public double getOutput(Race race) {
        return (primaryEngine.getOutput() + secondaryEngine.getOutput()) - this.getWeight() + (race.getOceanCurrentSpeed() / 5.0);
    }


}
