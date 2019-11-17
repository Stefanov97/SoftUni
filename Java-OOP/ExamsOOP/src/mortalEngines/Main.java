package mortalEngines;

import mortalEngines.core.MachineFactoryImpl;
import mortalEngines.core.MachinesManagerImpl;

import mortalEngines.core.PilotFactoryImpl;
import mortalEngines.core.interfaces.MachineFactory;
import mortalEngines.core.interfaces.PilotFactory;
import mortalEngines.core.interfaces.MachinesManager;
import mortalEngines.entities.interfaces.Machine;
import mortalEngines.entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"Over".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String name = tokens[1];
            String message = "";
            switch (command) {
                case "Hire":
                    message = machinesManager.hirePilot(name);
                    break;
                case "Report":
                    message = machinesManager.pilotReport(name);
                    break;

                case "ManufactureTank": {
                    double attackPoints = Double.parseDouble(tokens[2]);
                    double defensePoints = Double.parseDouble(tokens[3]);
                    message = machinesManager.manufactureTank(name, attackPoints, defensePoints);
                    break;
                }
                case "ManufactureFighter":
                    double attackPoints = Double.parseDouble(tokens[2]);
                    double defensePoints = Double.parseDouble(tokens[3]);
                    message = machinesManager.manufactureFighter(name, attackPoints, defensePoints);
                    break;

                case "Engage":
                    String machineName = tokens[2];
                    message = machinesManager.engageMachine(name, machineName);
                    break;

                case "Attack":
                    String defendingMachineName = tokens[2];
                    message = machinesManager.attackMachines(name, defendingMachineName);
                    break;

                case "DefenseMode":
                    message = machinesManager.toggleTankDefenseMode(name);
                    break;

                case "AggressiveMode":
                    message = machinesManager.toggleFighterAggressiveMode(name);
                    break;
            }
            System.out.println(message);
            line = scanner.nextLine();
        }

    }
}
