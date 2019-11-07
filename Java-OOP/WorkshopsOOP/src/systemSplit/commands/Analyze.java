package systemSplit.commands;

import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;

import java.util.Map;

public class Analyze extends BaseCommand {
    public Analyze(String commandName, TheSystem system, Object... args) {
        super(commandName, system, args);
    }

    @Override
    protected void parseInput(Object... args) {

    }

    @Override
    public void execute() {
        Map<String, Hardware> hardwareComponents = super.getSystem().getHardwareComponents();


        int countOfHardwares = hardwareComponents.size();
        final int[] countOfSoftwares = {0};
        hardwareComponents.values().stream().forEach(hardware -> {
            countOfSoftwares[0] += hardware.getSoftwares().size();
        });
        final long[] totalOperationalMemoryInUse = {0};
        hardwareComponents.values().stream().forEach(hardware -> {
            totalOperationalMemoryInUse[0] += hardware.getSoftwares().stream().mapToLong(software -> software.getMemoryConsumption()).sum();
        });

        long maximumMemory = hardwareComponents.values().stream().mapToLong(h -> h.getMaximumMemory() + h.getTotalUsedMemory()).sum();
        final long[] totalCapacityTaken = {0};
        hardwareComponents.values().stream().forEach(hardware -> {
            totalCapacityTaken[0] += hardware.getSoftwares().stream().mapToLong(software -> software.getCapacityConsumption()).sum();
        });
        long maximumCapacity = hardwareComponents.values().stream().mapToLong(h -> h.getMaximumCapacity() + h.getTotalUsedCapacity()).sum();

        StringBuilder sb = new StringBuilder();
        sb.append("System Analysis").append(System.lineSeparator());
        sb.append(String.format("Hardware Components: %d%n", countOfHardwares));
        sb.append(String.format("Software Components: %d%n", countOfSoftwares[0]));
        sb.append(String.format("Total Operational Memory: %d / %d%n", totalOperationalMemoryInUse[0], maximumMemory));
        sb.append(String.format("Total Capacity Taken: %d / %d%n", totalCapacityTaken[0], maximumCapacity));

        System.out.println(sb.toString().trim());
    }
}
