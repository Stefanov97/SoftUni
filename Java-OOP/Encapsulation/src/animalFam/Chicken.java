package animalFam;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    private void validateAge(int age) {
        if (age < 0 || age >= 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggsPerDay;

        if (this.age < 6) {
            eggsPerDay = 2;
        } else if (this.age < 12) {
            eggsPerDay = 1;
        } else {
            eggsPerDay = 0.75;
        }
        return eggsPerDay;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, this.calculateProductPerDay());
    }
}
