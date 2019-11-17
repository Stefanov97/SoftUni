package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
        this.exploredPlanets = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);

                break;
            default:
                throw new IllegalArgumentException("Astronaut type doesn't exists!");
        }
        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName, items);
        this.planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (this.astronautRepository.findByName(astronautName) == null) {
            throw new IllegalArgumentException(String.format("Astronaut %s doesn't exists!", astronautName));
        }
        this.astronautRepository.remove(this.astronautRepository.findByName(astronautName));
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = this.planetRepository.findByName(planetName);
        Collection<Astronaut> models = this.astronautRepository.getModels();
        ArrayList<Astronaut> astroauts = new ArrayList<>(models);
        List<Astronaut> filtered = astroauts.stream().filter(astronaut -> astronaut.getOxygen() > 60).collect(Collectors.toList());
        if (filtered.isEmpty()) {
            throw new IllegalArgumentException("You need at least one astronaut to explore the planet!");
        }
        int countBeforeMission = filtered.size();
        this.mission.explore(planet, filtered);
        this.exploredPlanets++;
        List<Astronaut> survived = filtered.stream().filter(Astronaut::canBreath).collect(Collectors.toList());
        int dead = countBeforeMission - survived.size();
        return String.format(PLANET_EXPLORED, planetName, dead);

    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, this.exploredPlanets)).append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        this.astronautRepository.getModels().forEach(astronaut -> sb.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName())).append(System.lineSeparator())
                .append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen())).append(System.lineSeparator())
                .append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, astronaut.getBag().getItems().isEmpty() ? "none" : String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems()))).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
