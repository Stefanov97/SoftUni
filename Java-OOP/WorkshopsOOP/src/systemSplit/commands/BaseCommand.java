package systemSplit.commands;

import systemSplit.interfaces.Executable;
import systemSplit.core.TheSystem;

public abstract class BaseCommand implements Executable {
    private String commandName;
    private TheSystem system;

    public BaseCommand(String commandName, TheSystem system, Object... args) {
        this.commandName = commandName;
        this.parseInput(args);
        this.system = system;
    }

    public BaseCommand(String commandName, TheSystem system) {
        this.commandName = commandName;
        this.system = system;
    }


    public TheSystem getSystem() {
        return this.system;
    }

    protected abstract void parseInput(Object... args);
}
