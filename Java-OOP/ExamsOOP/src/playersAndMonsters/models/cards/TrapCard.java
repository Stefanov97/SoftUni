package playersAndMonsters.models.cards;

public class TrapCard extends BaseCard {
    private static final int defaultDamagePoints = 120;
    private static final int defaultHealthPoints = 5;
    public TrapCard(String name) {
        super(name, defaultDamagePoints, defaultHealthPoints);
    }
}
