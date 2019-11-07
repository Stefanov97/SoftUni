package boatRacingSimulator.models.boats;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.helpers.Validator;
import boatRacingSimulator.interfaces.Outputable;

import java.util.Objects;

public abstract class Boat implements Outputable, Comparable<Boat> {
    private static final int MIN_BOAT_MODEL_LENGTH = 5;
    private String model;
    private int weight;

    protected Boat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setWeight(int weight) throws ArgumentException {
        if (Validator.validatePositiveParam(weight)) {
            this.weight = weight;
        } else {
            throw new ArgumentException(Validator.generateArgumentExceptionMessage("Weight"));
        }
    }

    private void setModel(String model) throws ArgumentException {
        if (Validator.validateBoatModel(model)) {
            this.model = model;
        } else {
            throw new ArgumentException(String.format("Model's name must be at least %d symbols long.", MIN_BOAT_MODEL_LENGTH));
        }
    }

    public String getModel() {
        return this.model;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
        Boat boat = (Boat) o;
        return model.equals(boat.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public int compareTo(Boat boat) {
        return this.getModel().compareTo(boat.getModel());
    }


}
