package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 70;
    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        this.setOxygen(this.getOxygen() - 5);
        if (this.getOxygen() < 0) {
            this.setOxygen(0);
        }
    }
}
