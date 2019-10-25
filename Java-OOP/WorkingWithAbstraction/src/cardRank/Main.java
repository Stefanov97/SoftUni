package cardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        CardRank[] values = CardRank.values();
        for (CardRank value : values) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(), value));
        }
    }
}
