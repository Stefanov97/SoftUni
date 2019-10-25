package cardsWithPower;

public class Card {
    RankPower rankPower;
    SuitPower suitPower;

    public Card(RankPower rankPower, SuitPower suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    public int calculatePower() {
        return this.suitPower.getValue() + this.rankPower.getValue();
    }
}
