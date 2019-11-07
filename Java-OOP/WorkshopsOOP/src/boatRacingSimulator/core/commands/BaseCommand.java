package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.*;

public abstract class BaseCommand {
    private String name;
    private Database database;

    public BaseCommand(String name, Database database, Object... args) {
        this.name = name;
        this.database = database;
        this.parseInput(args);
    }

    public Database getDatabase() {
        return database;
    }

    protected abstract void parseInput(Object... args);

    public abstract void executeCommand() throws ArgumentException, DuplicateModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
