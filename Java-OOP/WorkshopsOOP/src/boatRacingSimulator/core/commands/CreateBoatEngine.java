package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.models.boatEngines.BoatEngine;
import boatRacingSimulator.models.boatEngines.Jet;
import boatRacingSimulator.models.boatEngines.Sterndrive;

public class CreateBoatEngine extends BaseCommand {
    private String model;
    private int horsepower;
    private int displacement;
    private String type;

    public CreateBoatEngine(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.model = args[1].toString();
        this.horsepower = Integer.parseInt(args[2].toString());
        this.displacement = Integer.parseInt(args[3].toString());
        this.type = args[4].toString();
    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException {
        BoatEngine engine = null;
        switch (this.type) {
            case "Jet":
                engine = new Jet(this.model, this.horsepower, this.displacement);
                break;
            case "Sterndrive":
                engine = new Sterndrive(this.model, this.horsepower, this.displacement);
                break;
        }
        try {
            this.getDatabase().getEngineRepository().addEngine(engine);
            System.out.println(String.format("Engine model %s with %d HP and displacement %d cm3 created successfully.", this.model, this.horsepower, this.displacement));
        } catch (DuplicateModelException ignored) {

        }


    }
}
