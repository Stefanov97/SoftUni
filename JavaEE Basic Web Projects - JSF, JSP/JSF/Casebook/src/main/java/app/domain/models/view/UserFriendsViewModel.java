package app.domain.models.view;

import java.util.List;

public class UserFriendsViewModel {
    private String username;
    private List<UserFriendsViewModel> friends;

    public UserFriendsViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserFriendsViewModel> getFriends() {
        return friends;
    }

    public void setFriends(List<UserFriendsViewModel> friends) {
        this.friends = friends;
    }
}
