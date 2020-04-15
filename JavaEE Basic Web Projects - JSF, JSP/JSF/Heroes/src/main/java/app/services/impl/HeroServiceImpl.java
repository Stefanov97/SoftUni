package app.services.impl;

import app.domain.entities.Clazz;
import app.domain.entities.Hero;
import app.domain.models.service.HeroServiceModel;
import app.repositories.HeroRepository;
import app.services.HeroService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;
    @Inject
    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(HeroServiceModel hero) {
        Hero heroToSave = this.modelMapper.map(hero, Hero.class);
        heroToSave.setClazz(Clazz.valueOf(hero.getClazz().toUpperCase()));
        this.heroRepository.save(heroToSave);
    }

    @Override
    public void deleteById(String id) {
        this.heroRepository.deleteById(id);
    }

    @Override
    public List<HeroServiceModel> getAll() {
        return this.heroRepository.findAll().stream().map(h-> this.modelMapper.map(h,HeroServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public HeroServiceModel getById(String id) {
        return this.modelMapper.map(this.heroRepository.findById(id), HeroServiceModel.class);
    }
}
