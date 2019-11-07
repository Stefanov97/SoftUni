package boatRacingSimulator.models.boats;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.helpers.Validator;
import boatRacingSimulator.models.races.Race;

public class SailBoat extends Boat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if (Validator.validateBoatsEffectiveness(sailEfficiency)) {
            this.sailEfficiency = sailEfficiency;
        } else {
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
    }

    @Override
    public double getOutput(Race race) {
        int windSpeed = race.getWindSpeed();
        int sailEff = this.sailEfficiency;
        int weight = this.getWeight();
        int oceanCurrentSpeed = race.getOceanCurrentSpeed();
        return (windSpeed * (sailEff / 100.0)) - weight + (oceanCurrentSpeed / 2.0);

    }
}
