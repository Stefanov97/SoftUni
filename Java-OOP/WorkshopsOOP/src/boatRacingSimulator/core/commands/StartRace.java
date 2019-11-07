package boatRacingSimulator.core.commands;

import boatRacingSimulator.dataLayer.Database;
import boatRacingSimulator.exceptions.*;
import boatRacingSimulator.models.boats.Boat;
import boatRacingSimulator.models.races.Race;

import java.util.*;
import java.util.stream.Collectors;

public class StartRace extends BaseCommand {
    public StartRace(String name, Database database, Object... args) {
        super(name, database, args);
    }

    @Override
    protected void parseInput(Object... args) {

    }

    @Override
    public void executeCommand() throws ArgumentException, DuplicateModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        Race race = this.getDatabase().getRace();
        if (race == null) {
            throw new NoSetRaceException("There is currently no race set.");
        }
        Set<Boat> participants = race.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException("Not enough contestants for the race.");
        }
        participants = participants
                .stream()
                .sorted((f, s) -> {
                    if (f.getOutput(race) < 0 && s.getOutput(race) < 0) {
                        return 0;
                    }
                    return Double.compare(s.getOutput(race), f.getOutput(race));
                })
                .collect(Collectors.toCollection(LinkedHashSet::new));


        StringBuilder builder = new StringBuilder();

        List<Boat> finished = participants
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        String[] placesTable = {
                "First place: ",
                "Second place: ",
                "Third place: "
        };

        for (int i = 0; i < finished.size(); i++) {
            builder
                    .append(placesTable[i])
                    .append(finished.get(i).getClass().getSimpleName())
                    .append(" Model: ")
                    .append(finished.get(i).getModel())
                    .append(" Time: ");

            double time = race.getDistance() / finished.get(i).getOutput(race);

            String timeValue = (time < 0
                    || time == Double.POSITIVE_INFINITY
                    || time == Double.NEGATIVE_INFINITY)
                    ? "Did not finish!" : String.format("%.2f sec", time);
            builder
                    .append(timeValue)
                    .append(System.lineSeparator());
        }

        System.out.println(builder.toString().trim());
        this.getDatabase().setRace(null);
    }
}
