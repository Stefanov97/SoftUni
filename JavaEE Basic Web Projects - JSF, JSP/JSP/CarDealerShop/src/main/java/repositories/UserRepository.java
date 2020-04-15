package repositories;

import domain.entities.User;

public interface UserRepository {
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    void registerUser(User user);
    User findByUsernameAndPassword(String username, String password);
}
