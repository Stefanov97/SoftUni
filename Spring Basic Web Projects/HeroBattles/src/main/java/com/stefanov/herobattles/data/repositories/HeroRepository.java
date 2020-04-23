package com.stefanov.herobattles.data.repositories;

import com.stefanov.herobattles.data.models.Hero;
import com.stefanov.herobattles.service.models.HeroServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String> {
    Optional<Hero> findByName(String name);

    Optional<Hero> findByUserUsername(String username);
}
