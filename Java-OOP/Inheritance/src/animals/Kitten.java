package animals;

public class Kitten extends Cat {
    private static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    public String getGender() {
        return GENDER;
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
