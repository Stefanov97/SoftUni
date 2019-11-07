package boatRacingSimulator.dataLayer;

import boatRacingSimulator.core.Engine;
import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.exceptions.NonExistantModelException;
import boatRacingSimulator.models.boatEngines.BoatEngine;

import java.util.LinkedHashMap;
import java.util.Map;

public class EngineRepository {
    private Map<String, BoatEngine> engineRepository;

    public EngineRepository() {
        this.engineRepository = new LinkedHashMap<>();
    }

    public BoatEngine getEngine(String model) throws NonExistantModelException {
        if (!this.engineRepository.containsKey(model)) {
            throw new NonExistantModelException();
        }
        return this.engineRepository.get(model);
    }

    public void addEngine(BoatEngine engine) throws DuplicateModelException {
        String model = engine.getModel();
        if (this.engineRepository.containsKey(model)) {
            throw new DuplicateModelException();
        }
        this.engineRepository.put(model, engine);
    }
}
