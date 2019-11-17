package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<Astronaut> validAstronauts = astronauts.stream().filter(Astronaut::canBreath).collect(Collectors.toList());
        Collection<String> collectionOfItems = planet.getItems();
        List<String> planetItems = collectionOfItems.stream().collect(Collectors.toList());
        for (Astronaut astronaut : validAstronauts) {
            if(planetItems.isEmpty()){
                break;
            }
            while (astronaut.canBreath()) {
                String item = planetItems.get(0);
                astronaut.getBag().getItems().add(item);
                planetItems.remove(item);
                astronaut.breath();
                if(planetItems.isEmpty()){
                    break;
                }
            }
        }
    }
}
