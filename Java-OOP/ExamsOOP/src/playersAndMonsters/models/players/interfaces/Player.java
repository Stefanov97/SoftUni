package playersAndMonsters.models.players.interfaces;

import playersAndMonsters.repositories.interfaces.CardRepository;

public interface Player {
    CardRepository getCardRepository();

    String getUsername();

    int getHealth();

    void setHealth(int healthPoints);

    boolean isDead();

    void takeDamage(int damagePoints);
}
