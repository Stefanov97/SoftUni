package boatRacingSimulator.dataLayer;

import boatRacingSimulator.models.races.Race;

public class Database {
    private BoatRepository boatRepository;
    private EngineRepository engineRepository;
    private Race race;

    public Database(BoatRepository boatRepository, EngineRepository engineRepository) {
        this.boatRepository = boatRepository;
        this.engineRepository = engineRepository;
        this.race = null;
    }

    public BoatRepository getBoatRepository() {
        return this.boatRepository;
    }

    public EngineRepository getEngineRepository() {
        return this.engineRepository;
    }

    public Race getRace() {
        return this.race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
