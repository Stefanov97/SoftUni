package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    @Inject
    private Repository repository;
    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        String output = unitType + " retired!";

        try {
            this.repository.removeUnit(unitType);
        } catch (ExecutionControl.NotImplementedException | IllegalArgumentException e) {
           output = e.getMessage();
        }

        return output;
    }
}
