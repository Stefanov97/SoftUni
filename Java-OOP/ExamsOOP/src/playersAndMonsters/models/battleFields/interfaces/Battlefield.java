package playersAndMonsters.models.battleFields.interfaces;

import playersAndMonsters.models.players.interfaces.Player;

public interface Battlefield {
    void fight(Player attackPlayer, Player enemyPlayer);
}
