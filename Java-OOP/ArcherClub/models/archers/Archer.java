package models.archers;

import enums.Gender;
import models.bows.Bow;

public interface Archer {
    String getName();

    Gender getGender();

    int getAge();

    Bow getBow();

    int getExperience();

    int getCompetitionsCount();

    void participate();

    int shoot();

    int getMaxPointHits();

    void addMaxPointHit();

    int getMissedShots();

    void miss();

}
