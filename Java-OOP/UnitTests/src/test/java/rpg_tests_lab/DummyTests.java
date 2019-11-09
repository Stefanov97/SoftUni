package rpg_tests_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class DummyTests {
    private static final int DEFAULT_ATTACK_POINTS = 10;
    private static final int DEFAULT_DURABILITY_POINTS = 10;
    private static final int DEFAULT_HEALTH_POINTS = 20;
    private static final int DEFAULT_EXPERIENCE_POINTS = 8;
    private static final int EXPECTED_HEALTH = 10;
    private static final int EXPECTED_EXPERIENCE = 8;
    private Weapon weapon;
    private Target target;

    @Before
    public void initializeWeaponAndTarget() {
        this.weapon = new Axe(DEFAULT_ATTACK_POINTS, DEFAULT_DURABILITY_POINTS);
        this.target = new Dummy(DEFAULT_HEALTH_POINTS, DEFAULT_EXPERIENCE_POINTS);
    }

    @Test
    public void isDummyLosesHealthAfterItHasBeenAttacked() {
        this.weapon.attack(this.target);
        Assert.assertEquals("Dummy does not loses health after attack!", EXPECTED_HEALTH, this.target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void isDeadDummyThrowsExceptionIfIsAttacked() {
        for (int i = 0; i < 3; i++) {
            this.weapon.attack(this.target);
        }
    }

    @Test()
    public void isDeadDummyCanGiveXP() {
        for (int i = 0; i < 2; i++) {
            this.weapon.attack(this.target);
        }
        Assert.assertEquals("Dead dummy must give XP!", EXPECTED_EXPERIENCE, this.target.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void isAliveDummyCanGiveXP() {
        Assert.assertEquals("Alive dummy can not give XP!", EXPECTED_EXPERIENCE, this.target.giveExperience());
    }
}
