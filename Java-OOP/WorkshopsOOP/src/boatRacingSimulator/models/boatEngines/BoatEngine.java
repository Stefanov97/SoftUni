package boatRacingSimulator.models.boatEngines;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.helpers.Validator;
import boatRacingSimulator.interfaces.Outputable;

import java.util.Objects;

public abstract class BoatEngine implements Comparable<BoatEngine> {
    private static final int MIN_MODEL_LENGTH = 3;
    private String model;
    private int horsepower;
    private int displacement;

    public BoatEngine(String model, int horsepower, int displacement) throws ArgumentException {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    private void setHorsepower(int horsepower) throws ArgumentException {
        if (Validator.validatePositiveParam(horsepower)) {
            this.horsepower = horsepower;
        } else {
            throw new ArgumentException(Validator.generateArgumentExceptionMessage("Horsepower"));
        }
    }

    private void setDisplacement(int displacement) throws ArgumentException {
        if (Validator.validatePositiveParam(displacement)) {
            this.displacement = displacement;
        } else {
            throw new ArgumentException(Validator.generateArgumentExceptionMessage("Displacement"));
        }
    }

    private void setModel(String model) throws ArgumentException {
        if (Validator.validateBoatEngineModel(model)) {
            this.model = model;
        } else {
            throw new ArgumentException(String.format("Model's name must be at least %d symbols long.", MIN_MODEL_LENGTH));
        }
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public abstract int getOutput();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
        BoatEngine that = (BoatEngine) o;
        return model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public int compareTo(BoatEngine engine) {
        return this.getModel().compareTo(engine.getModel());
    }
}
