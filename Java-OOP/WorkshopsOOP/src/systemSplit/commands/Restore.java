package systemSplit.commands;

import systemSplit.core.TheDump;
import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;

import java.util.Map;

public class Restore extends BaseCommand {
    private String componentName;

    public Restore(String commandName, TheSystem system, Object... args) {
        super(commandName, system, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.componentName = args[1].toString();
    }

    @Override
    public void execute() {
        TheDump system = (TheDump) this.getSystem();
        Map<String, Hardware> hardwareComponents = system.getHardwareComponents();
        Map<String, Hardware> theDump = system.getTheDump();
        if (theDump.containsKey(this.componentName)) {
            Hardware hardware = theDump.get(this.componentName);
            hardwareComponents.put(this.componentName, hardware);
            theDump.remove(this.componentName);
        }
    }
}
