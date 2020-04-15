package app.domain.models.view;

import app.domain.entities.Gender;

public class UserHomeViewModel {
    private String username;
    private String gender;

    public UserHomeViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
