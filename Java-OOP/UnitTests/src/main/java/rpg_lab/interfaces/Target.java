package rpg_lab.interfaces;

public interface Target {
    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();

    String getLoot();
}
