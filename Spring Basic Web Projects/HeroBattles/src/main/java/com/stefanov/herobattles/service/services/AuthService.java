package com.stefanov.herobattles.service.services;

import com.stefanov.herobattles.service.models.UserServiceModel;

public interface AuthService {
    void register(UserServiceModel user) throws IllegalAccessException;
    UserServiceModel login(UserServiceModel user) throws  IllegalAccessException;
}
