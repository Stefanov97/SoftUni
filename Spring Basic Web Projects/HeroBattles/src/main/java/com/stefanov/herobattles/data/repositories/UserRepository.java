package com.stefanov.herobattles.data.repositories;

import com.stefanov.herobattles.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
