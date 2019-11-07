package boatRacingSimulator.core;

import boatRacingSimulator.dataLayer.BoatRepository;
import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.dataLayer.EngineRepository;

public class Main {
    public static void main(String[] args) {
        BoatRepository boatRepository = new BoatRepository();
        EngineRepository engineRepository = new EngineRepository();
        Database database = new Database(boatRepository, engineRepository);
        Engine engine = new Engine(database);

        engine.run();
    }
}
