package com.stefanov.herobattles.service.services;

import com.stefanov.herobattles.data.models.Hero;
import com.stefanov.herobattles.service.models.HeroServiceModel;
import com.stefanov.herobattles.web.models.HeroHomeViewModel;

import java.util.List;

public interface HeroService {
    HeroServiceModel getByName(String username);

    Hero createHero(HeroServiceModel hero);

    List<HeroServiceModel> getAllOpponents(String heroName);

    String fight(String heroName, String opponentName);

    HeroServiceModel getByUsername(String username);
}
