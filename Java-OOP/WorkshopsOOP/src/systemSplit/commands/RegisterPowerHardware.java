package systemSplit.commands;

import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;
import systemSplit.hardware.PowerHardware;

import java.util.Map;

public class RegisterPowerHardware extends BaseCommand {
    private String name;
    private int capacity;
    private int memory;


    public RegisterPowerHardware(String commandName, TheSystem system, Object... args) {
        super(commandName, system, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.name = args[1].toString();
        this.capacity = Integer.parseInt(args[2].toString());
        this.memory = Integer.parseInt(args[3].toString());
    }

    @Override
    public void execute() {
        Map<String, Hardware> hardwareComponents = super.getSystem().getHardwareComponents();
        Hardware hardware = new PowerHardware(this.name, this.capacity, this.memory);
        hardwareComponents.put(this.name, hardware);

    }
}
