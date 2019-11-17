package playersAndMonsters.models.battleFields;

import playersAndMonsters.models.battleFields.interfaces.Battlefield;
import playersAndMonsters.models.cards.interfaces.Card;
import playersAndMonsters.models.players.interfaces.Player;
import playersAndMonsters.repositories.interfaces.CardRepository;

import java.util.List;

public class BattleFieldImpl implements Battlefield {

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }
        adjustPlayerIfItsBeginner(attackPlayer);
        adjustPlayerIfItsBeginner(enemyPlayer);

        addAdditionalHealthFromPlayersDeck(attackPlayer);
        addAdditionalHealthFromPlayersDeck(enemyPlayer);

        while (!attackPlayer.isDead() && !enemyPlayer.isDead()) {
            List<Card> attackerCards = attackPlayer.getCardRepository().getCards();
            for (Card card : attackerCards) {
                enemyPlayer.takeDamage(card.getDamagePoints());
            }
            if (enemyPlayer.isDead()) {
                break;
            }
            List<Card> enemyCards = enemyPlayer.getCardRepository().getCards();
            for (Card enemyCard : enemyCards) {
                attackPlayer.takeDamage(enemyCard.getDamagePoints());
            }
        }
    }

    private void addAdditionalHealthFromPlayersDeck(Player player) {
        CardRepository attackerRepo = player.getCardRepository();
        for (Card card : attackerRepo.getCards()) {
            player.setHealth(player.getHealth() + card.getHealthPoints());
        }
    }

    private void adjustPlayerIfItsBeginner(Player player) {
        if (player.getClass().getSimpleName().equals("Beginner")) {
            player.setHealth(player.getHealth() + 40);
            CardRepository cardRepository = player.getCardRepository();
            for (Card card : cardRepository.getCards()) {
                card.setDamagePoints(card.getDamagePoints() + 30);
            }
        }
    }
}
