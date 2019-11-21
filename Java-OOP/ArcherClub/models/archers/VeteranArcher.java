package models.archers;

import enums.Gender;
import models.bows.CarbonBow;

import java.util.Random;

public class VeteranArcher extends BaseArcher {
    public VeteranArcher(String name, Gender gender, int age, CarbonBow bow, int experience) {
        super(name, gender, age, bow, experience);
    }


    @Override
    public int shoot() {
        Random random = new Random();
        int min = 6;
        int max = 10;
        int totalPoints = 0;
        for (int i = 1; i <= 60; i++) {
            int points = random.nextInt((max - min - 1)) + min;
            if (points < 10) {
                CarbonBow bow = (CarbonBow) this.getBow();
                points += bow.getOptics() + bow.getStabilization();
                if (points > 10) {
                    points = 10;
                }
            }
            if (points == 10) {
                this.addMaxPointHit();
            }
            totalPoints += points;
        }
        return totalPoints;
    }
}
