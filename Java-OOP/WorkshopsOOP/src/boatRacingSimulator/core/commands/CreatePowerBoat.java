package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.exceptions.NonExistantModelException;
import boatRacingSimulator.models.boatEngines.BoatEngine;
import boatRacingSimulator.models.boats.PowerBoat;

public class CreatePowerBoat extends BaseCommand {
    private String model;
    private int weight;
    private BoatEngine primaryEngine;
    private BoatEngine secondaryEngine;

    public CreatePowerBoat(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.model = args[1].toString();
        this.weight = Integer.parseInt(args[2].toString());
        String primaryEngineName = args[3].toString();
        try {
            this.primaryEngine = this.getDatabase().getEngineRepository().getEngine(primaryEngineName);
        } catch (NonExistantModelException ignored) {

        }
        String secondaryEngineName = args[4].toString();
        try {
            this.secondaryEngine = this.getDatabase().getEngineRepository().getEngine(secondaryEngineName);
        } catch (NonExistantModelException ignored) {

        }
    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException {
        PowerBoat boat = new PowerBoat(this.model, this.weight, this.primaryEngine, this.secondaryEngine);
        try {
            this.getDatabase().getBoatRepository().addBoat(boat);
            System.out.println(String.format("Power boat with model %s registered successfully.", this.model));
        } catch (DuplicateModelException ignored) {

        }
    }
}
