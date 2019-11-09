package rpg_lab;

import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import java.util.ArrayList;
import java.util.List;


public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<String> inventory;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public List<String> getInventory() {
        return this.inventory;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.getLoot());
        }
    }
}
