package systemSplit.commands;

import systemSplit.core.TheDump;
import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;

import java.util.Map;

public class Dump extends BaseCommand {
    private String componentName;

    public Dump(String commandName, TheSystem system, Object... args) {
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
        if (hardwareComponents.containsKey(this.componentName)) {
            Hardware hardware = hardwareComponents.get(this.componentName);
            theDump.put(this.componentName, hardware);
            hardwareComponents.remove(this.componentName);
        }
    }
}
