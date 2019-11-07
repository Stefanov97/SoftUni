package boatRacingSimulator.core;

import boatRacingSimulator.core.commands.BaseCommand;
import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.*;
import boatRacingSimulator.models.races.Race;

import javax.xml.crypto.Data;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Engine {
    private static final String COMMAND_PATH = "boatRacingSimulator.core.commands.";
    private static final String END_OF_INPUT = "End";
    private Scanner scanner;
    private Database database;

    public Engine(Database database) {
        this.scanner = new Scanner(System.in);
        this.database = database;

    }

    public void run() {
        String line = this.scanner.nextLine();

        while (!line.equals(END_OF_INPUT)) {
            String[] tokens = line.split("\\\\");
            String commandName = tokens[0];
            try {
                Class<?> commandClass = Class.forName(COMMAND_PATH + commandName);
                Constructor<?> ctor = commandClass.getDeclaredConstructors()[0];
                BaseCommand currentCommand = (BaseCommand) ctor.newInstance(commandName, this.database, tokens);
                currentCommand.executeCommand();
            } catch (ArgumentException |
                    ClassNotFoundException |
                    InstantiationException |
                    IllegalAccessException |
                    InvocationTargetException |
                    RaceAlreadyExistsException |
                    NoSetRaceException |
                    InsufficientContestantsException ex) {
                System.out.println(ex.getMessage());
            } catch (DuplicateModelException ignored) {

            }
            line = this.scanner.nextLine();
        }

    }
}
