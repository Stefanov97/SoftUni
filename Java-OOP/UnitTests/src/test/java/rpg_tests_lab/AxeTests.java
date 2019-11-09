package rpg_tests_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class AxeTests {
    private static final int DEFAULT_ATTACK_POINTS = 10;
    private static final int DEFAULT_DURABILITY_POINTS = 10;
    private static final int DEFAULT_HEALTH_POINTS = 20;
    private static final int DEFAULT_EXPERIENCE_POINTS = 8;
    private Weapon weapon;
    private Target target;

    @Before
    public void initializeWeaponAndTarget() {
        this.weapon = new Axe(DEFAULT_ATTACK_POINTS, DEFAULT_DURABILITY_POINTS);
        this.target = new Dummy(DEFAULT_HEALTH_POINTS, DEFAULT_EXPERIENCE_POINTS);
    }

    @Test
    public void isWeaponLosesDurabilityAfterEachAttack() {
        this.weapon.attack(this.target);

        Assert.assertEquals(9, this.weapon.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void tryToAttackWithBrokenWeapon() {
        for (int i = 0; i < 11; i++) {
            this.weapon.attack(this.target);
        }

    }
}
