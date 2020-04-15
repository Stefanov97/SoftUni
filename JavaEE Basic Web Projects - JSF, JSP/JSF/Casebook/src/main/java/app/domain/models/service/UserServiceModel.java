package app.domain.models.service;

import app.domain.entities.Gender;
import app.domain.entities.User;

import java.util.List;

public class UserServiceModel {
    private String username;
    private String password;
    private String gender;
    List<UserServiceModel> friends;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<UserServiceModel> getFriends() {
        return friends;
    }

    public void setFriends(List<UserServiceModel> friends) {
        this.friends = friends;
    }
    public void addFriend(UserServiceModel user){
        this.getFriends().add(user);
    }
}
