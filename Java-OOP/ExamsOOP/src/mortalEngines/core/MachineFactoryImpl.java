package mortalEngines.core;

        import mortalEngines.core.interfaces.MachineFactory;
        import mortalEngines.entities.FighterImpl;
        import mortalEngines.entities.TankImpl;
        import mortalEngines.entities.interfaces.Fighter;
        import mortalEngines.entities.interfaces.Tank;

public class MachineFactoryImpl implements MachineFactory {
    @Override
    public Tank createTank(String name, double attackPoints, double defensePoints) {
        return new TankImpl(name, attackPoints, defensePoints);
    }

    @Override
    public Fighter createFighter(String name, double attackPoints, double defensePoints) {
        return new FighterImpl(name, attackPoints, defensePoints);
    }
}
