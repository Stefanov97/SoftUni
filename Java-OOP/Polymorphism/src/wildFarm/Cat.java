package wildFarm;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        String string = super.toString();
        int index = string.indexOf(",") + 2;
        StringBuilder sb = new StringBuilder(string);
        sb.insert(index, this.breed + ", ");

        return sb.toString();
    }
}
