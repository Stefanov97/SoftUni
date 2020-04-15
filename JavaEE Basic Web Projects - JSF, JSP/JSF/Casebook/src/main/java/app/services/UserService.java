package app.services;

import app.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void register(UserServiceModel user) throws IllegalAccessException;
    void loginUser(UserServiceModel user) throws IllegalAccessException;
    List<UserServiceModel> getAll();
    UserServiceModel getByUsername(String username);
    void addFriend(String username, String friendName);
    void removeFriend(String username, String friendName);
}
