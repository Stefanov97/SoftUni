package app.domain.models.view;

public class UserDetailsVeiwModel {
    private String username;
    private String gender;

    public UserDetailsVeiwModel() {
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
