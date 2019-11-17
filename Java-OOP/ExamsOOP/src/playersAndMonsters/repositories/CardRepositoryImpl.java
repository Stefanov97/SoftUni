package playersAndMonsters.repositories;

import playersAndMonsters.models.cards.interfaces.Card;
import playersAndMonsters.repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }
        List<Card> filtered = this.cards.stream().filter(card1 -> card1.getName().equals(card.getName())).collect(Collectors.toList());
        if (!filtered.isEmpty()) {
            throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
        }
        this.cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }
        return this.cards.remove(card);
    }

    @Override
    public Card find(String name) {
        Card card = null;
        card = this.cards.stream().filter(card1 -> card1.getName().equals(name)).findFirst().orElse(null);
        return card;
    }
}
