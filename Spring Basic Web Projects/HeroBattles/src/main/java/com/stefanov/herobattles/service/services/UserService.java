package com.stefanov.herobattles.service.services;

import com.stefanov.herobattles.service.models.HeroServiceModel;
import com.stefanov.herobattles.service.models.ItemServiceModel;
import com.stefanov.herobattles.service.models.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void addHero(String username, HeroServiceModel hero);
    void addItemToHero(String username, String itemName);

    UserServiceModel getByUsername(String username);
}
