package app.repositories;

import app.domain.entities.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    void update(User user);
    List<User> findAll();
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
