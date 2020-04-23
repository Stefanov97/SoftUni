package com.stefanov.herobattles.service.services;

import com.stefanov.herobattles.data.models.Gender;
import com.stefanov.herobattles.data.models.Hero;
import com.stefanov.herobattles.data.repositories.HeroRepository;
import com.stefanov.herobattles.error.HeroNotFoundException;
import com.stefanov.herobattles.service.models.HeroServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService{
    private static final String DRAW_GAME = "Draw";

    private final HeroRepository heroRepository;
    private final ModelMapper mapper;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper mapper){
        this.heroRepository = heroRepository;
        this.mapper = mapper;
    }

    @Override
    public HeroServiceModel getByName(String name) {
        Optional<Hero> optionalHero = this.heroRepository.findByName(name);
        if(optionalHero.isEmpty()){
            throw new HeroNotFoundException("There is no hero with this name");
        }
        Hero hero = optionalHero.get();
        return this.mapper.map(hero,HeroServiceModel.class);
    }

    @Override
    public Hero createHero(HeroServiceModel heroServiceModel) {
        Hero hero = this.mapper.map(heroServiceModel,Hero.class);
        hero.setLevel(1);
        hero.setStamina(1);
        hero.setStrength(1);
        hero.setAttack(1);
        hero.setDefence(1);
        hero.setGender(Gender.valueOf(heroServiceModel.getGender().toUpperCase()));
        return hero;
    }

    @Override
    public List<HeroServiceModel> getAllOpponents(String heroName) {
       return this.heroRepository.findAll().stream().filter(h->!h.getName().equals(heroName)).map(hero -> this.mapper.map(hero,HeroServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public String fight(String heroName, String opponentName) {
        Hero hero = this.heroRepository.findByName(heroName).get();
        Hero opponent = this.heroRepository.findByName(opponentName).get();

        int heroDemage = hero.getAttack() + (hero.getStrength() * 4) - (opponent.getDefence() + (opponent.getStamina() * 2));
        int opponentDemage = opponent.getAttack() + (opponent.getStrength() * 4) - (hero.getDefence() + (hero.getStamina() * 2));

        if(heroDemage > opponentDemage){
            levelUp(heroName);
            return heroName;
        }else if(heroDemage == opponentDemage){
            return DRAW_GAME;
        }else {
            levelUp(opponentName);
            return opponentName;
        }
    }

    @Override
    public HeroServiceModel getByUsername(String username) {
        Optional<Hero> hero = this.heroRepository.findByUserUsername(username);
        if(!hero.isEmpty()){
            return this.mapper.map(hero.get(),HeroServiceModel.class);
        }
        return null;
    }

    private void levelUp(String heroName) {
        Hero hero = this.heroRepository.findByName(heroName).get();
        hero.setLevel(hero.getLevel() + 1);
        hero.setStrength(hero.getStrength() + 5);
        hero.setStamina(hero.getStamina() + 5);
        this.heroRepository.saveAndFlush(hero);
    }
}
