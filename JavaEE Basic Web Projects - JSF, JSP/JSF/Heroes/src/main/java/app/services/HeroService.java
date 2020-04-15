package app.services;

import app.domain.entities.Hero;
import app.domain.models.service.HeroServiceModel;

import java.util.List;

public interface HeroService {
    void save(HeroServiceModel hero);
    void deleteById(String id);
    List<HeroServiceModel> getAll();
    HeroServiceModel getById(String id);
}
