package models.archers;

import enums.Gender;
import models.bows.Bow;

public abstract class BaseArcher implements Archer {
    private String name;
    private Gender gender;
    private int age;
    private Bow bow;
    private int experience;
    private int competitionsCount;
    private int maxPointsHits;
    private int missedShots;

    protected BaseArcher(String name, Gender gender, int age, Bow bow, int experience) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bow = bow;
        this.experience = experience;
        this.competitionsCount = 0;
        this.maxPointsHits = 0;
        this.missedShots = 0;
    }

    @Override
    public int getMissedShots() {
        return this.missedShots;
    }

    @Override
    public void miss() {
        this.missedShots++;
    }

    @Override
    public void addMaxPointHit() {
        this.maxPointsHits++;
    }

    @Override
    public int getMaxPointHits() {
        return this.maxPointsHits;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public Bow getBow() {
        return this.bow;
    }

    @Override
    public int getExperience() {
        return this.experience;
    }

    @Override
    public int getCompetitionsCount() {
        return this.competitionsCount;
    }

    @Override
    public void participate() {
        this.competitionsCount++;
    }
}
