package cardsWithPower;

public enum SuitPower {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    SuitPower(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
