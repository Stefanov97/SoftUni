package boatRacingSimulator.models.races;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.helpers.Validator;
import boatRacingSimulator.models.boats.Boat;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private boolean allowMotorboats;
    private Set<Boat> participants;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowMotorboats) throws ArgumentException {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowMotorboats = allowMotorboats;
        this.participants = new LinkedHashSet<>();
    }

    public int getDistance() {
        return distance;
    }

    public boolean isAllowMotorboats() {
        return this.allowMotorboats;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    private void setDistance(int distance) throws ArgumentException {
        if (Validator.validatePositiveParam(distance)) {
            this.distance = distance;
        } else {
            throw new ArgumentException(Validator.generateArgumentExceptionMessage("Distance"));
        }
    }

    public void addParticipant(Boat participant) throws DuplicateModelException {
        if (!this.participants.add(participant)) {
            throw new DuplicateModelException();
        }
    }

    public double calculateTime(Boat boat) {
        return (double) this.getDistance() / boat.getOutput(this);
    }

    public Set<Boat> getParticipants() {
        return Collections.unmodifiableSet((this.participants));
    }
}
