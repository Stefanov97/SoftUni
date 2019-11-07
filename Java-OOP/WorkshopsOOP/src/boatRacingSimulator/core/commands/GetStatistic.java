package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.BoatRepository;
import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.*;
import boatRacingSimulator.models.boats.Boat;

import java.util.Map;

public class GetStatistic extends BaseCommand {
    public GetStatistic(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {

    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        BoatRepository boatRepository = this.getDatabase().getBoatRepository();
        Map<String, Boat> boatsRepository = boatRepository.getBoatsRepository();
        double powerBoat = 0;
        double rowBoat = 0;
        double sailBoat = 0;
        double yacht = 0;
        double allBoats = boatsRepository.size();

        for (Map.Entry<String, Boat> entry : boatsRepository.entrySet()) {
            Boat boat = entry.getValue();
            switch (boat.getClass().getSimpleName()) {
                case "PowerBoat":
                    powerBoat++;
                    break;
                case "RowBoat":
                    rowBoat++;
                    break;

                case "SailBoat":
                    sailBoat++;
                    break;

                case "Yacht":
                    yacht++;
                    break;
            }
        }
        powerBoat = powerBoat / allBoats * 100.;
        rowBoat = rowBoat / allBoats * 100;
        sailBoat = sailBoat / allBoats * 100;
        yacht = yacht / allBoats * 100;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("PowerBoat -> %.2f%%%n", powerBoat));
        sb.append(String.format("RowBoat -> %.2f%%%n", rowBoat));
        sb.append(String.format("SailBoat -> %.2f%%%n", sailBoat));
        sb.append(String.format("Yacht -> %.2f%%%n", yacht));
        System.out.println(sb.toString().trim());
    }
}
