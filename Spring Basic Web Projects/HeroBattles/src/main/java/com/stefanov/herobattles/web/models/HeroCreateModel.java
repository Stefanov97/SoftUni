package com.stefanov.herobattles.web.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class HeroCreateModel {
    @NotEmpty
    private String name;
    @NotEmpty
    private String gender;
}
