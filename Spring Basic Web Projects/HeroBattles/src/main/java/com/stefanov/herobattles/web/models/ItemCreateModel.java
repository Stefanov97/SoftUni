package com.stefanov.herobattles.web.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ItemCreateModel {
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty
    private String slot;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;
}
