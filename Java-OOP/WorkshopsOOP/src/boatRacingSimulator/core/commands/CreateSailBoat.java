package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.models.boats.SailBoat;

public class CreateSailBoat extends BaseCommand {
    private String model;
    private int weight;
    private int sailEfficiency;

    public CreateSailBoat(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.model = args[1].toString();
        this.weight = Integer.parseInt(args[2].toString());
        this.sailEfficiency = Integer.parseInt(args[3].toString());
    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException {
        SailBoat boat = new SailBoat(this.model, this.weight, this.sailEfficiency);
        try {
            this.getDatabase().getBoatRepository().addBoat(boat);
            System.out.println(String.format("Sail boat with model %s registered successfully.", this.model));
        } catch (DuplicateModelException ignored) {

        }
    }
}
