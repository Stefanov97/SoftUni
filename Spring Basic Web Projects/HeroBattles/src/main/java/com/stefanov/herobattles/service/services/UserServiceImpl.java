package com.stefanov.herobattles.service.services;

import com.stefanov.herobattles.data.models.*;
import com.stefanov.herobattles.data.repositories.HeroRepository;
import com.stefanov.herobattles.data.repositories.ItemRepository;
import com.stefanov.herobattles.data.repositories.UserRepository;
import com.stefanov.herobattles.service.models.HeroServiceModel;
import com.stefanov.herobattles.service.models.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final HeroRepository heroRepository;
    private final ItemRepository itemRepository;
    private final HeroService heroService;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository, HeroRepository heroRepository, ItemRepository itemRepository,HeroService heroService){
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.heroRepository = heroRepository;
        this.itemRepository = itemRepository;
        this.heroService = heroService;
    }
    @Override
    public void addHero(String username, HeroServiceModel heroServiceModel) {
        User user = this.userRepository.findByUsername(username);
        Hero hero = this.heroService.createHero(heroServiceModel);
        hero.setUser(user);
        this.heroRepository.save(hero);
        user.setHero(hero);
        this.userRepository.save(user);
    }

    @Override
    public void addItemToHero(String username, String itemName) {
        User user = this.userRepository.findByUsername(username);
        Hero hero = user.getHero();
        Item item = this.itemRepository.findByName(itemName);
        hero.getItems().add(item);
        hero.setStamina(hero.getStamina() + item.getStamina());
        hero.setStrength(hero.getStrength() + item.getStrength());
        hero.setAttack(hero.getAttack() + item.getAttack());
        hero.setDefence(hero.getDefence() + item.getDefence());
        this.heroRepository.saveAndFlush(hero);

    }

    @Override
    public UserServiceModel getByUsername(String username) {
        return this.mapper.map(this.userRepository.findByUsername(username),UserServiceModel.class);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        Set<GrantedAuthority> authorities = new HashSet<>(user.getAuthorities());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}
