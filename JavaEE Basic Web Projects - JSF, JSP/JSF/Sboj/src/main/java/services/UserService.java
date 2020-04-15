package services;

import domain.models.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel user) throws IllegalAccessException;
    void loginUser(UserServiceModel user) throws IllegalAccessException;
}
