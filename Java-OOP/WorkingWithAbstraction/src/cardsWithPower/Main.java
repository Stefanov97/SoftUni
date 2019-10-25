package cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(RankPower.valueOf(type), SuitPower.valueOf(suit));
        int cardPower = card.calculatePower();
        System.out.println(String.format("Card name: %s of %s; Card power: %d", type, suit, cardPower));
    }
}
