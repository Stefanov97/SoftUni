package systemSplit.commands;

import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;
import systemSplit.software.Software;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SystemSplit extends BaseCommand {
    public SystemSplit(String commandName, TheSystem system, Object... args) {
        super(commandName, system, args);
    }

    public SystemSplit(String commandName, TheSystem system) {
        super(commandName, system);
    }

    @Override
    protected void parseInput(Object... args) {

    }

    @Override
    public void execute() {
        Map<String, Hardware> hardwareComponents = super.getSystem().getHardwareComponents();

        StringBuilder sb = new StringBuilder();
        hardwareComponents.values().stream().sorted((f, s) -> s.getType().compareTo(f.getType())

        ).forEach(hardware -> {
            String componentName = hardware.getName();
            List<Software> express = hardware.getSoftwares().stream().filter(software -> software.getType().equalsIgnoreCase("express")).collect(Collectors.toList());
            int countOfLightSoftwares = hardware.getSoftwares().size() - express.size();
            int memoryUsage = hardware.getTotalUsedMemory();
            long maximumMemory = hardware.getMaximumMemory() + hardware.getTotalUsedMemory();
            int capacityUsed = hardware.getTotalUsedCapacity();
            long maximumCapacity = hardware.getMaximumCapacity() + hardware.getTotalUsedCapacity();
            String type = hardware.getType();
            sb.append(String.format("Hardware Component - %s%n", componentName));
            sb.append(String.format("Express Software Components - %d%n", express.size()));
            sb.append(String.format("Light Software Components - %d%n", countOfLightSoftwares));
            sb.append(String.format("Memory Usage: %d / %d%n", memoryUsage, maximumMemory));
            sb.append(String.format("Capacity Usage: %d / %d%n", capacityUsed, maximumCapacity));
            sb.append(String.format("Type: %s%n", type));
            sb.append("Software Components: ");
            List<Software> softwares = hardware.getSoftwares();
            if (softwares.isEmpty()) {
                sb.append("None").append(System.lineSeparator());
            }
            for (int i = 0; i < softwares.size(); i++) {
                Software software = softwares.get(i);
                String name = software.getName();
                if (i == softwares.size() - 1) {
                    sb.append(name).append(System.lineSeparator());
                } else {
                    sb.append(name + ", ");
                }

            }
        });
        System.out.println(sb.toString().trim());
    }
}
