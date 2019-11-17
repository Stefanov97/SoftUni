package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;
import java.util.stream.Collectors;

public class AstronautRepository implements Repository<Astronaut> {
    private List<Astronaut> astronauts;

    public AstronautRepository(){
        this.astronauts = new ArrayList<>();
    }
    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableList(this.astronauts);
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
       return this.astronauts.remove(astronaut);
    }

    @Override
    public Astronaut findByName(String name) {
        Astronaut astronautFound = this.astronauts.stream().filter(astronaut -> astronaut.getName().equals(name)).findFirst().orElse(null);
        return astronautFound;


    }
}
