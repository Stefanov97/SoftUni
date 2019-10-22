package arena;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FightingArena {
    private List<Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new ArrayList<>();

    }

    public void add(Gladiator entity) {
        this.gladiators.add(entity);
    }

    public void remove(String name) {
        for (int i = 0; i < gladiators.size(); i++) {
            Gladiator gladiator = gladiators.get(i);
            if (gladiator.getName().equals(name)) {
                this.gladiators.remove(gladiator);
                i--;
            }
        }
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        int power = 0;
        Gladiator bestGladiator = new Gladiator("", new Stat(0, 0, 0, 0, 0), new Weapon(0, 0, 0));
        for (Gladiator gladiator : gladiators) {
            if (gladiator.getStatPower() > power) {
                power = gladiator.getStatPower();
                bestGladiator = gladiator;
            }
        }
        return bestGladiator;
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        int power = 0;
        Gladiator bestGladiator = new Gladiator("", new Stat(0, 0, 0, 0, 0), new Weapon(0, 0, 0));
        for (Gladiator gladiator : gladiators) {
            if (gladiator.getWeaponPower() > power) {
                power = gladiator.getWeaponPower();
                bestGladiator = gladiator;
            }
        }
        return bestGladiator;
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        int power = 0;
        Gladiator bestGladiator = new Gladiator("", new Stat(0, 0, 0, 0, 0), new Weapon(0, 0, 0));
        for (Gladiator gladiator : gladiators) {
            if (gladiator.getTotalPower() > power) {
                power = gladiator.getTotalPower();
                bestGladiator = gladiator;
            }
        }
        return bestGladiator;
    }

    public int getCount() {
        return gladiators.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String firstLine = String.format("%s – %d gladiators are participating.", this.name, this.getCount());
        sb.append(firstLine);
        return sb.toString();
    }
}
