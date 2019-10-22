package spaceStationRecruitment;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private List<Astronaut> data;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Astronaut astronaut) {
        if (this.getCount() < this.getCapacity()) {
            this.data.add(astronaut);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;
        for (Astronaut person : this.data) {
            if (person.getName().equals(name)) {
                this.data.remove(person);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Astronaut getOldestAstronaut() {
        Astronaut oldest = null;
        int oldestAge = -1;
        for (Astronaut astronaut : this.data) {
            if (astronaut.getAge() > oldestAge) {
                oldestAge = astronaut.getAge();
                oldest = astronaut;
            }
        }
        return oldest;
    }

    public Astronaut getAstronaut(String name) {
        Astronaut toReturn = null;
        for (Astronaut astronaut : this.data) {
            if (astronaut.getName().equals(name)) {
                toReturn = astronaut;
                break;
            }
        }

        return toReturn;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:", this.name)).append(System.lineSeparator());
        for (Astronaut astronaut : this.data) {
            sb.append(astronaut.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
