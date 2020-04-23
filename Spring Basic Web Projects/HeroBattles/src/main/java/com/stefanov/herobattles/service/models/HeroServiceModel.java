package com.stefanov.herobattles.service.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HeroServiceModel {
    private String name;
    private String gender;
    private int level;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;
    private List<ItemServiceModel> items;
    private UserServiceModel user;
}
