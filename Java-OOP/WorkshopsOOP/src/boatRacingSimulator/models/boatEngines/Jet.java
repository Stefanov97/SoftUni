package boatRacingSimulator.models.boatEngines;

import boatRacingSimulator.exceptions.ArgumentException;

public class Jet extends BoatEngine {
    public Jet(String model, int horsepower, int displacement) throws ArgumentException {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (this.getHorsepower() * 5) + this.getDisplacement();
    }
}
