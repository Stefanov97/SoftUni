package app.services;

import app.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void register(UserServiceModel user) throws IllegalAccessException;
    void loginUser(UserServiceModel user) throws IllegalAccessException;
    void save(UserServiceModel user);
    UserServiceModel getByUsername(String username);
    List<UserServiceModel> getAll();

}
