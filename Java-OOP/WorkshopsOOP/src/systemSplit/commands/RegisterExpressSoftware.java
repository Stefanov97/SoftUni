package systemSplit.commands;

import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;
import systemSplit.hardware.HeavyHardware;
import systemSplit.hardware.PowerHardware;
import systemSplit.software.ExpressSoftware;
import systemSplit.software.Software;

import java.util.Map;

public class RegisterExpressSoftware extends BaseCommand {
    private String hardwareComponentName;
    private String name;
    private int capacity;
    private int memory;

    public RegisterExpressSoftware(String commandName, TheSystem system, Object... args) {
        super(commandName, system, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.hardwareComponentName = args[1].toString();
        this.name = args[2].toString();
        this.capacity = Integer.parseInt(args[3].toString());
        this.memory = Integer.parseInt(args[4].toString());

    }

    @Override
    public void execute() {
        Map<String, Hardware> hardwareComponents = super.getSystem().getHardwareComponents();
        if (hardwareComponents.containsKey(this.hardwareComponentName)) {

            if (hardwareComponents.get(hardwareComponentName).getType().equalsIgnoreCase("heavy")) {
                HeavyHardware hardware = (HeavyHardware) hardwareComponents.get(hardwareComponentName);
                Software software = new ExpressSoftware(this.name, this.capacity, this.memory);
                if (hardware.getMaximumCapacity() >= software.getCapacityConsumption() && hardware.getMaximumMemory() >= software.getMemoryConsumption()) {
                    hardware.addSoftwareToGivenComponent(software);
                    hardware.reduceMemoryAndCapacity(software);
                }
            } else {
                PowerHardware hardware = (PowerHardware) hardwareComponents.get(hardwareComponentName);
                Software software = new ExpressSoftware(this.name, this.capacity, this.memory);
                if (hardware.getMaximumCapacity() >= software.getCapacityConsumption() && hardware.getMaximumMemory() >= software.getMemoryConsumption()) {
                    hardware.addSoftwareToGivenComponent(software);
                    hardware.reduceMemoryAndCapacity(software);
                }
            }

        }
    }
}
