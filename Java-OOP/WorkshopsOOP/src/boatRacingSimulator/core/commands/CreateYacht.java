package boatRacingSimulator.core.commands;


import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.exceptions.NonExistantModelException;
import boatRacingSimulator.models.boatEngines.BoatEngine;
import boatRacingSimulator.models.boats.Yacht;

public class CreateYacht extends BaseCommand {
    private String model;
    private int weight;
    private BoatEngine engine;
    private int cargoWeight;

    public CreateYacht(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.model = args[1].toString();
        this.weight = Integer.parseInt(args[2].toString());
        String primaryEngineName = args[3].toString();
        try {
            this.engine = this.getDatabase().getEngineRepository().getEngine(primaryEngineName);
        } catch (NonExistantModelException ignored) {

        }
        this.cargoWeight = Integer.parseInt(args[4].toString());
    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException {
        Yacht boat = new Yacht(this.model, this.weight, this.engine, this.cargoWeight);
        try {
            this.getDatabase().getBoatRepository().addBoat(boat);
            System.out.println(String.format("Yacht with model %s registered successfully.", this.model));
        } catch (DuplicateModelException ignored) {

        }
    }
}
