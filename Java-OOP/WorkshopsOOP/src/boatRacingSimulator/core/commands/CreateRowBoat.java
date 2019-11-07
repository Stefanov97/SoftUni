package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.models.boats.RowBoat;

public class CreateRowBoat extends BaseCommand {
    private String model;
    private int weight;
    private int oars;

    public CreateRowBoat(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.model = args[1].toString();
        this.weight = Integer.parseInt(args[2].toString());
        this.oars = Integer.parseInt(args[3].toString());
    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException {
        RowBoat boat = new RowBoat(this.model, this.weight, this.oars);
        try {
            this.getDatabase().getBoatRepository().addBoat(boat);
            System.out.println(String.format("Row boat with model %s registered successfully.", this.model));
        } catch (DuplicateModelException ignored) {

        }

    }
}
