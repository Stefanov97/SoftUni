package domain.models.service;

import domain.entities.Car;

import java.util.HashSet;
import java.util.Set;

public class UserServiceModel {
    private String username;
    private String password;
    private String email;
    private Set<Car> cars;

    public UserServiceModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.cars = new HashSet<>();
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
