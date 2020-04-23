package com.stefanov.herobattles.data.repositories;

import com.stefanov.herobattles.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {
    Item findByName(String name);
}
