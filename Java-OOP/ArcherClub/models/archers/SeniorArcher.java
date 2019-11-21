package models.archers;

import enums.Gender;
import models.bows.AluminiumBow;
import models.bows.CarbonBow;
import models.bows.SpecialBow;

import java.util.Random;

public class SeniorArcher extends BaseArcher {
    public SeniorArcher(String name, Gender gender, int age, SpecialBow bow, int experience) {
        super(name, gender, age, bow, experience);
    }

    @Override
    public int shoot() {
        Random random = new Random();
        int min = 6;
        int max = 10;
        int totalPoints = 0;
        for (int i = 1; i <= 60; i++) {
            int points;
            if (i % 20 == 0) {
                points = random.nextInt(9);
            } else {
                points = random.nextInt((max - min - 1)) + min;
            }
            if (points < 10) {
                if (this.getBow().getClass().getSimpleName().equals("CarbonBow")) {
                    CarbonBow bow = (CarbonBow) this.getBow();
                    points += bow.getOptics() + bow.getStabilization();
                } else {
                    AluminiumBow bow = (AluminiumBow) this.getBow();
                    points += bow.getOptics();
                }
                if (points > 10) {
                    points = 10;
                }
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
