package models.archers;

import enums.Gender;
import models.bows.WoodenBow;

import java.util.Random;

public class JuniorArcher extends BaseArcher {
    private static final int EXPERIENCE = 1;

    public JuniorArcher(String name, Gender gender, int age, WoodenBow bow) {
        super(name, gender, age, bow, EXPERIENCE);
    }

    @Override
    public int shoot() {
        Random random = new Random();
        int min = 1;
        int max = 10;
        int totalPoints = 0;
        for (int i = 1; i <= 30; i++) {
            int points;
            if (i % 10 == 0) {
                points = random.nextInt(9);
            } else {
                points = random.nextInt((max - min - 1)) + min;
            }
            if (points == 10) {
                this.addMaxPointHit();
            } else if (points == 0) {
                this.miss();
            }
            totalPoints += points;
        }
        return totalPoints;
    }
}
