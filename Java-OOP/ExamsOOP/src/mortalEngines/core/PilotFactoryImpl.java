package mortalEngines.core;

import mortalEngines.core.interfaces.PilotFactory;
import mortalEngines.entities.PilotImpl;
import mortalEngines.entities.interfaces.Pilot;

public class PilotFactoryImpl implements PilotFactory {
    @Override
    public Pilot createPilot(String name) {
        return new PilotImpl(name);
    }
}
