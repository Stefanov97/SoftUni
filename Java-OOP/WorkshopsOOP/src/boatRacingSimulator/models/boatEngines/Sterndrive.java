package boatRacingSimulator.models.boatEngines;

import boatRacingSimulator.exceptions.ArgumentException;

public class Sterndrive extends BoatEngine {
    public Sterndrive(String model, int horsepower, int displacement) throws ArgumentException {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (this.getHorsepower() * 7) + this.getDisplacement();
    }
}
