package mortalEngines.core.interfaces;

import mortalEngines.entities.interfaces.Fighter;
import mortalEngines.entities.interfaces.Tank;

public interface MachineFactory {
    Tank createTank(String name, double attackPoints, double defensePoints);

    Fighter createFighter(String name, double attackPoints, double defensePoints);
}
