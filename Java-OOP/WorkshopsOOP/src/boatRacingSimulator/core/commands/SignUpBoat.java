package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.*;
import boatRacingSimulator.models.boats.Boat;
import boatRacingSimulator.models.races.Race;

public class SignUpBoat extends BaseCommand {
    private String model;

    public SignUpBoat(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.model = args[1].toString();
    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException, RaceAlreadyExistsException, NoSetRaceException {
        Race race = this.getDatabase().getRace();
        Boat boat = null;
        try {
            boat = this.getDatabase().getBoatRepository().getBoat(this.model);
        } catch (NonExistantModelException ignored) {

        }
        if (race == null) {
            throw new NoSetRaceException("There is currently no race set.");
        }
        boolean allowMotorboats = race.isAllowMotorboats();
        if (!allowMotorboats) {
            if (boat.getClass().getSimpleName().equals("Yacht") || boat.getClass().getSimpleName().equals("PowerBoat")) {
                throw new ArgumentException("The specified boat does not meet the race constraints.");
            }
        }
        race.addParticipant(boat);
        System.out.println(String.format("Boat with model %s has signed up for the current Race.", this.model));

    }
}
