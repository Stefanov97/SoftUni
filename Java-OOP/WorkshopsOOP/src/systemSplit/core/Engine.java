package systemSplit.core;

import systemSplit.commands.BaseCommand;
import systemSplit.interfaces.Runnable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Engine implements Runnable {
    private static final String COMMAND_PATH = "systemSplit.commands.";
    private static final String END_OF_COMMANDS = "System Split";
    private Scanner scanner;
    private TheSystem system;

    public Engine(Scanner scanner, TheSystem system) {
        this.scanner = scanner;
        this.system = system;
    }

    @Override
    public void run() {
        String line = this.scanner.nextLine();
        while (!END_OF_COMMANDS.equals(line)) {
            String[] tokens = line.split("[(),\\s]+");
            String commandName = tokens[0];
            try {
                Class<?> currentCommand = Class.forName(COMMAND_PATH + commandName);
                Constructor<?> ctor = currentCommand.getDeclaredConstructors()[0];
                BaseCommand commandClass = (BaseCommand) ctor.newInstance(commandName, this.system, tokens);
                commandClass.execute();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            line = this.scanner.nextLine();
        }
        try {
            Class<?> currentCommand = Class.forName(COMMAND_PATH + "SystemSplit");
            Constructor<?> ctor = currentCommand.getDeclaredConstructor(String.class, TheSystem.class);
            BaseCommand commandClass = (BaseCommand) ctor.newInstance("SystemSplit", this.system);
            commandClass.execute();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
