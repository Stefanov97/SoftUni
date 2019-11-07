package systemSplit.commands;

import systemSplit.core.TheDump;
import systemSplit.core.TheSystem;
import systemSplit.hardware.Hardware;
import systemSplit.software.Software;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DumpAnalyze extends BaseCommand {
    public DumpAnalyze(String commandName, TheSystem system, Object... args) {
        super(commandName, system, args);
    }

    @Override
    protected void parseInput(Object... args) {

    }

    @Override
    public void execute() {
        TheDump system = (TheDump) super.getSystem();
        Map<String, Hardware> theDump = system.getTheDump();
        List<Hardware> powerHardwares = theDump.values().stream().filter(hardware -> hardware.getType().equalsIgnoreCase("power")).collect(Collectors.toList());
        List<Hardware> heavyHardwares = theDump.values().stream().filter(hardware -> hardware.getType().equalsIgnoreCase("heavy")).collect(Collectors.toList());
        int expressCount = 0;
        int lightCount = 0;
        int totalDumpMemory = 0;
        int totalDumpedCapacity = 0;
        for (Map.Entry<String, Hardware> entry : theDump.entrySet()) {
            Hardware hardware = entry.getValue();
            totalDumpedCapacity += hardware.getTotalUsedCapacity();
            totalDumpMemory += hardware.getTotalUsedMemory();
            List<Software> softwares = hardware.getSoftwares();
            List<Software> express = softwares.stream().filter(software -> software.getType().equalsIgnoreCase("express")).collect(Collectors.toList());
            List<Software> light = softwares.stream().filter(software -> software.getType().equalsIgnoreCase("light")).collect(Collectors.toList());
            expressCount += express.size();
            lightCount += light.size();
        }


        StringBuilder sb = new StringBuilder();
        sb.append("Dump Analysis").append(System.lineSeparator());
        sb.append(String.format("Power Hardware Components: %d%n", powerHardwares.size()));
        sb.append(String.format("Heavy Hardware Components: %d%n", heavyHardwares.size()));
        sb.append(String.format("Express Software Components: %d%n", expressCount));
        sb.append(String.format("Light Software Components: %d%n", lightCount));
        sb.append(String.format("Total Dumped Memory: %d%n", totalDumpMemory));
        sb.append(String.format("Total Dumped Capacity: %d", totalDumpedCapacity));
        System.out.println(sb.toString().trim());
    }
}
