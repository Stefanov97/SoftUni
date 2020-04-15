package repositories;

import domain.entities.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> findAll();
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameAndPassword(String username, String password);
}
