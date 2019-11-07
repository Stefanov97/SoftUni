package systemSplit.commands;

import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;
import systemSplit.hardware.HeavyHardware;
import systemSplit.hardware.PowerHardware;
import systemSplit.software.Software;

import java.util.Map;

public class ReleaseSoftwareComponent extends BaseCommand {
    private String hardwareName;
    private String softwareName;

    public ReleaseSoftwareComponent(String commandName, TheSystem system, Object... args) {
        super(commandName, system, args);
    }

    @Override
    protected void parseInput(Object... args) {
        this.hardwareName = args[1].toString();
        this.softwareName = args[2].toString();
    }

    @Override
    public void execute() {
        Map<String, Hardware> hardwareComponents = super.getSystem().getHardwareComponents();
        if (hardwareComponents.containsKey(this.hardwareName)) {

            if (hardwareComponents.get(this.hardwareName).getType().equalsIgnoreCase("heavy")) {
                HeavyHardware hardware = (HeavyHardware) hardwareComponents.get(this.hardwareName);
                Software software = null;
                for (Software currentSoftware : hardware.getSoftwares()) {
                    if (currentSoftware.getName().equals(this.softwareName)) {
                        software = currentSoftware;
                        break;
                    }
                }
                if (software != null) {
                    hardware.releaseSoftware(software);

                    hardware.releaseMemoryAndCapacity(software);
                }
            } else {
                PowerHardware hardware = (PowerHardware) hardwareComponents.get(this.hardwareName);
                Software software = null;
                for (Software currentSoftware : hardware.getSoftwares()) {
                    if (currentSoftware.getName().equals(this.softwareName)) {
                        software = currentSoftware;
                        break;
                    }
                }
                if (software != null) {
                    hardware.releaseSoftware(software);
                    hardware.releaseMemoryAndCapacity(software);
                }
            }
        }
    }
}
