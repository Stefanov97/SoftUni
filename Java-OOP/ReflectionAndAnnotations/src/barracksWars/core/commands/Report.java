package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;
    protected Report(String[] data) {
        super(data);

    }

    @Override
    public String execute() {
       return this.repository.getStatistics();

    }
}
