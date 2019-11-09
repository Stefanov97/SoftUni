package rpg_tests_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTests {
    private static final int DEFAULT_ATTACK_POINTS = 10;
    private static final int DEFAULT_DURABILITY_POINTS = 10;
    private static final int DEFAULT_HEALTH_POINTS = 20;
    private static final int DEFAULT_EXPERIENCE_POINTS = 8;
    private static final String HERO_NAME = "Pavel";
    private static final String DEFAULT_LOOT = "DEFAULT LOOT";
    private Hero hero;
    private Weapon weapon;
    private Target target;

    @Before
    public void initializeWeaponAndTarget() {
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        Mockito.when(mockedWeapon.getAttackPoints()).thenReturn(DEFAULT_ATTACK_POINTS);
        Mockito.when(mockedWeapon.getDurabilityPoints()).thenReturn(DEFAULT_DURABILITY_POINTS);
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.getLoot()).thenReturn(DEFAULT_LOOT);
        Mockito.when(mockedTarget.isDead()).thenReturn(Boolean.TRUE);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(DEFAULT_EXPERIENCE_POINTS);
        Mockito.when(mockedTarget.getHealth()).thenReturn(DEFAULT_HEALTH_POINTS);
        this.target = mockedTarget;
        this.weapon = mockedWeapon;
        this.hero = new Hero(HERO_NAME, this.weapon);

    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        this.hero.attack(this.target);
        Assert.assertEquals("Wrong experience!", DEFAULT_EXPERIENCE_POINTS, this.hero.getExperience());
    }

    @Test
    public void isHeroGettingLootAfterKillingATarget() {
        this.hero.attack(this.target);
        Assert.assertEquals("Hero must collect loot!", DEFAULT_LOOT, this.hero.getInventory().get(0));
    }


}
