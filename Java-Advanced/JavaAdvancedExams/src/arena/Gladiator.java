package arena;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getStatPower() {

        return this.stat.getStrength() + this.stat.getFlexibility() + this.stat.getAgility() + this.stat.getSkills() + this.stat.getIntelligence();
    }

    public int getWeaponPower() {

        int power = this.weapon.getSharpness() + this.weapon.getSize() + this.weapon.getSolidity();
        return power;
    }

    public int getTotalPower() {
        int power = getStatPower() + getWeaponPower();

        return power;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String firstLine = String.format("%s - %d", this.name, this.getTotalPower());
        sb.append(firstLine);
        sb.append(System.lineSeparator());

        String secondLine = String.format("  Weapon Power: %d", this.getWeaponPower());
        sb.append(secondLine);
        sb.append(System.lineSeparator());

        String thirdLine = String.format("  Stat Power: %d", this.getStatPower());
        sb.append(thirdLine);

        return sb.toString();
    }
}
