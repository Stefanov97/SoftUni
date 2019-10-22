package heroRepository;

public class Hero {
    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s – %d", this.getName(), this.getLevel())).append(System.lineSeparator());
        sb.append(String.format("  *  Strength: %d", this.item.getStrength())).append(System.lineSeparator());
        sb.append(String.format("  *  Agility: %d", this.item.getAgility())).append(System.lineSeparator());
        sb.append(String.format("  *  Intelligence: %d", this.item.getIntelligence())).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
