package services;

import domain.models.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel user) throws IllegalAccessException;
    UserServiceModel loginUser(String username, String password) throws IllegalAccessException;
}
