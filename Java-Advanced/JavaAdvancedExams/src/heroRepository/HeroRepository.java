package heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero> repository;

    public HeroRepository() {
        this.repository = new ArrayList<>();
    }

    public void add(Hero hero) {
        this.repository.add(hero);
    }

    public void remove(String name) {
        for (Hero hero : repository) {
            if (hero.getName().equals(name)) {
                repository.remove(hero);
                break;
            }
        }

    }

    public Hero getHeroWithHighestStrength() {
        Item item = new Item(-1, 0, 0);
        Hero bestStrengthHero = new Hero("", -1, item);
        for (Hero hero : repository) {
            if (hero.getItem().getStrength() > bestStrengthHero.getItem().getStrength()) {
                bestStrengthHero = hero;
            }
        }


        return bestStrengthHero;
    }

    public Hero getHeroWithHighestAgility() {
        Item item = new Item(-1, -1, 0);
        Hero bestAgilityHero = new Hero("", -1, item);
        for (Hero hero : repository) {
            if (hero.getItem().getAgility() > bestAgilityHero.getItem().getAgility()) {
                bestAgilityHero = hero;
            }
        }


        return bestAgilityHero;
    }

    public Hero getHeroWithHighestIntelligence() {
        Item item = new Item(-1, -1, -1);
        Hero bestIntelligenceHero = new Hero("", -1, item);
        for (Hero hero : repository) {
            if (hero.getItem().getIntelligence() > bestIntelligenceHero.getItem().getIntelligence()) {
                bestIntelligenceHero = hero;
            }
        }
        return bestIntelligenceHero;
    }

    public int getCount() {
        return this.repository.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Hero hero : repository) {
            sb.append(hero.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
