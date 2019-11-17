package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.*;

public class PlanetRepository implements Repository<Planet> {
    private List<Planet> planets;

    public PlanetRepository(){
        this.planets = new ArrayList<>();
    }
    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableList(this.planets);
    }

    @Override
    public void add(Planet planet) {
        this.planets.add(planet);
    }

    @Override
    public boolean remove(Planet planet) {
      return this.planets.remove(planet);
    }

    @Override
    public Planet findByName(String name) {
            return this.planets.stream().filter(planet -> planet.getName().equals(name)).findFirst().orElse(null);

    }
}
