package mortalEngines.core;

import mortalEngines.common.OutputMessages;
import mortalEngines.core.interfaces.MachineFactory;
import mortalEngines.core.interfaces.PilotFactory;
import mortalEngines.core.interfaces.MachinesManager;

import mortalEngines.entities.FighterImpl;
import mortalEngines.entities.TankImpl;
import mortalEngines.entities.interfaces.Fighter;
import mortalEngines.entities.interfaces.Machine;
import mortalEngines.entities.interfaces.Pilot;
import mortalEngines.entities.interfaces.Tank;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }


    @Override
    public String hirePilot(String name) {
        if (!pilots.containsKey(name)) {
            Pilot pilot = pilotFactory.createPilot(name);
            pilots.put(name, pilot);
            String message = OutputMessages.pilotHired;
            return String.format(message, name);
        } else {
            return String.format(OutputMessages.pilotExists, name);
        }
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if (!machines.containsKey(name)) {
            Tank tank = machineFactory.createTank(name, attackPoints, defensePoints);
            this.machines.put(name, tank);
            String message = OutputMessages.tankManufactured;
            return String.format(message, name, attackPoints, defensePoints);
        } else {
            return String.format(OutputMessages.machineExists, name);
        }
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (!machines.containsKey(name)) {
            Fighter fighter = machineFactory.createFighter(name, attackPoints, defensePoints);
            this.machines.put(name, fighter);
            String message = OutputMessages.fighterManufactured;
            return String.format(message, name, attackPoints, defensePoints);
        } else {
            return String.format(OutputMessages.machineExists, name);
        }
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        Pilot pilot = null;
        Machine machine = null;
        if (pilots.containsKey(selectedPilotName)) {
            pilot = pilots.get(selectedPilotName);
        } else {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }
        if (machines.containsKey(selectedMachineName)) {
            machine = machines.get(selectedMachineName);
        } else {
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        }
        if (machine.getPilot() != null) {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }
        pilot.addMachine(machine);
        machine.setPilot(pilot);
        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        String message = "";
        if (!machines.containsKey(attackingMachineName)) {
            return String.format(OutputMessages.machineNotFound, attackingMachineName);
        }
        if (!machines.containsKey(defendingMachineName)) {
            return String.format(OutputMessages.machineNotFound, defendingMachineName);
        }

        Machine attackingMachine = machines.get(attackingMachineName);
        Machine defendingMachine = machines.get(defendingMachineName);
        if (attackingMachine.getAttackPoints() >= defendingMachine.getDefensePoints()) {
            defendingMachine.setHealthPoints(defendingMachine.getHealthPoints() - (attackingMachine.getAttackPoints() - defendingMachine.getDefensePoints()));
            if (defendingMachine.getHealthPoints() < 0) {
                defendingMachine.setHealthPoints(0);
            }
        }
        message = String.format(OutputMessages.attackSuccessful, defendingMachineName, attackingMachineName, defendingMachine.getHealthPoints());
        attackingMachine.attack(defendingMachineName);
        return message;

    }

    @Override
    public String pilotReport(String pilotName) {
        if (!pilots.containsKey(pilotName)) {
            return String.format(OutputMessages.pilotNotFound, pilotName);
        }
        Pilot pilot = pilots.get(pilotName);
        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (!machines.containsKey(fighterName)) {
            return String.format(OutputMessages.machineNotFound, fighterName);
        }
        Machine machine = machines.get(fighterName);
        if (machine.getClass().getSimpleName().contains("Tank")) {
            return String.format(OutputMessages.notSupportedOperation, fighterName);
        }
        FighterImpl fighter = (FighterImpl) machines.get(fighterName);
        fighter.toggleAggressiveMode();

        return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (!machines.containsKey(tankName)) {
            return String.format(OutputMessages.machineNotFound, tankName);
        }

        Machine machine = machines.get(tankName);
        if (machine.getClass().getSimpleName().contains("Fighter")) {
            return String.format(OutputMessages.notSupportedOperation, tankName);
        }
        TankImpl defender = (TankImpl) machines.get(tankName);
        defender.toggleDefenseMode();

        return String.format(OutputMessages.tankOperationSuccessful, tankName);
    }
}
