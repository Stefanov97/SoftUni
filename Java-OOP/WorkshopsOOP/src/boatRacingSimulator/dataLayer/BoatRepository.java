package boatRacingSimulator.dataLayer;

import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.exceptions.NonExistantModelException;
import boatRacingSimulator.models.boats.Boat;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository {
    private Map<String, Boat> boatsRepository;

    public BoatRepository() {
        this.boatsRepository = new LinkedHashMap<>();
    }

    public Boat getBoat(String model) throws NonExistantModelException {
        if (!this.boatsRepository.containsKey(model)) {
            throw new NonExistantModelException("Invalid boat model!");
        }
        return this.boatsRepository.get(model);
    }

    public Map<String, Boat> getBoatsRepository() {
        return this.boatsRepository;
    }

    public void addBoat(Boat boat) throws DuplicateModelException {
        String model = boat.getModel();
        if (this.boatsRepository.containsKey(model)) {
            throw new DuplicateModelException();
        }
        this.boatsRepository.put(model, boat);
    }
}
