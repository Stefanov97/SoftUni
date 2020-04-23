package com.stefanov.herobattles.service.models;

import com.stefanov.herobattles.data.models.Hero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private HeroServiceModel hero;

}
