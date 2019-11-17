package playersAndMonsters.core;

import playersAndMonsters.common.ConstantMessages;
import playersAndMonsters.core.interfaces.ManagerController;
import playersAndMonsters.models.battleFields.BattleFieldImpl;
import playersAndMonsters.models.battleFields.interfaces.Battlefield;
import playersAndMonsters.models.cards.MagicCard;
import playersAndMonsters.models.cards.TrapCard;
import playersAndMonsters.models.cards.interfaces.Card;
import playersAndMonsters.models.players.Advanced;
import playersAndMonsters.models.players.Beginner;
import playersAndMonsters.models.players.interfaces.Player;
import playersAndMonsters.repositories.CardRepositoryImpl;
import playersAndMonsters.repositories.PlayerRepositoryImpl;
import playersAndMonsters.repositories.interfaces.CardRepository;
import playersAndMonsters.repositories.interfaces.PlayerRepository;


public class ManagerControllerImpl implements ManagerController {
    private CardRepository cardRepository;
    private PlayerRepository playerRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        this.cardRepository = new CardRepositoryImpl();
        this.playerRepository = new PlayerRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player newPlayer = null;
        switch (type) {
            case "Beginner":

                newPlayer = new Beginner(new CardRepositoryImpl(), username);
                break;
            case "Advanced":
                newPlayer = new Advanced(new CardRepositoryImpl(), username);
                break;
        }
        this.playerRepository.add(newPlayer);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card newCard = null;
        switch (type) {
            case "Magic":

                newCard = new MagicCard(name);
                break;
            case "Trap":
                newCard = new TrapCard(name);
                break;
        }
        this.cardRepository.add(newCard);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Card card = this.cardRepository.find(cardName);
        Player player = this.playerRepository.find(username);
        player.getCardRepository().add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = this.playerRepository.find(attackUser);
        Player enemy = this.playerRepository.find(enemyUser);
        this.battlefield.fight(attacker, enemy);
        return String.format(ConstantMessages.FIGHT_INFO, attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Player player : this.playerRepository.getPlayers()) {
            sb.append(String.format(ConstantMessages.PLAYER_REPORT_INFO, player.getUsername(), player.getHealth(), player.getCardRepository().getCount())).append(System.lineSeparator());
            for (Card card : player.getCardRepository().getCards()) {
                sb.append(String.format(ConstantMessages.CARD_REPORT_INFO, card.getName(), card.getDamagePoints())).append(System.lineSeparator());
            }
            sb.append(ConstantMessages.DEFAULT_REPORT_SEPARATOR).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
