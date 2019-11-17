package playersAndMonsters.models.cards;

public class MagicCard extends BaseCard {
    private static final int defaultDamagePoints = 5;
    private static final int defaultHealthPoints = 80;
    public MagicCard(String name) {
        super(name, defaultDamagePoints, defaultHealthPoints);
    }

}
