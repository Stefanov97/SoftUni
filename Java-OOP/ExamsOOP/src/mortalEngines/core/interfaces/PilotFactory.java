package mortalEngines.core.interfaces;

import mortalEngines.entities.interfaces.Pilot;

public interface PilotFactory {
    Pilot createPilot(String name);
}
