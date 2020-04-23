package com.stefanov.herobattles.service.models;

import com.stefanov.herobattles.data.models.Hero;
import com.stefanov.herobattles.data.models.Slot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ItemServiceModel {
    private String name;
    private String slot;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;
    List<HeroServiceModel> heroes;
}
