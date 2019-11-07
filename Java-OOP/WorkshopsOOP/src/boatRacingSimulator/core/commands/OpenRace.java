package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.exceptions.DuplicateModelException;
import boatRacingSimulator.exceptions.RaceAlreadyExistsException;
import boatRacingSimulator.models.races.Race;

public class OpenRace extends BaseCommand {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private boolean allowMotorboats;

    public OpenRace(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.distance = Integer.parseInt(args[1].toString());
        this.windSpeed = Integer.parseInt(args[2].toString());
        this.oceanCurrentSpeed = Integer.parseInt(args[3].toString());
        this.allowMotorboats = Boolean.parseBoolean(args[4].toString());
    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException, RaceAlreadyExistsException {
        Race race = this.getDatabase().getRace();
        if (race != null) {
            throw new RaceAlreadyExistsException("The current race has already been set.");
        }
        race = new Race(this.distance, this.windSpeed, this.oceanCurrentSpeed, this.allowMotorboats);
        this.getDatabase().setRace(race);
        System.out.println(String.format("A new race with distance %d meters, wind speed %d m/s and ocean current speed %d m/s has been set.", this.distance, this.windSpeed, this.oceanCurrentSpeed));
    }
}
