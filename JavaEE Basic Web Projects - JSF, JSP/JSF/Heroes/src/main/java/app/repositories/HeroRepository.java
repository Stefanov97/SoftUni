package app.repositories;

import app.domain.entities.Hero;

import java.util.List;

public interface HeroRepository {
    void save(Hero hero);
    void deleteById(String id);
    List<Hero> findAll();
    Hero findById(String id);
}
