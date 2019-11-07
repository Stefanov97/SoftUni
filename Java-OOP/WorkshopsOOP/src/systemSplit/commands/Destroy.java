package systemSplit.commands;

import systemSplit.core.TheDump;
import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;

import java.util.Map;

public class Destroy extends BaseCommand {
    private String componentName;

    public Destroy(String commandName, TheSystem system, Object... args) {
        super(commandName, system, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.componentName = args[1].toString();
    }

    @Override
    public void execute() {
        TheDump system = (TheDump) super.getSystem();
        Map<String, Hardware> theDump = system.getTheDump();
        if (theDump.containsKey(this.componentName)) {
            theDump.remove(this.componentName);
        }
    }
}
