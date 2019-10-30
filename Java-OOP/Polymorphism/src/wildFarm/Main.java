package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String line = scanner.nextLine();
        int index = 0;
        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            if (index % 2 == 0) {
                String type = tokens[0];
                String name = tokens[1];
                double weight = Double.parseDouble(tokens[2]);
                String region = tokens[3];
                switch (tokens[0]) {
                    case "Cat":
                        String catBreed = tokens[4];
                        Animal cat = new Cat(name, type, weight, region, catBreed);
                        animals.add(cat);
                        cat.makeSound();
                        break;
                    case "Tiger":
                        Animal tiger = new Tiger(name, type, weight, region);
                        animals.add(tiger);
                        tiger.makeSound();
                        break;
                    case "Zebra":
                        Animal zebra = new Zebra(name, type, weight, region);
                        animals.add(zebra);
                        zebra.makeSound();
                        break;
                    case "Mouse":
                        Animal mouse = new Mouse(name, type, weight, region);
                        animals.add(mouse);
                        mouse.makeSound();
                        break;

                }

            } else {
                String type = tokens[0];
                int quantity = Integer.parseInt(tokens[1]);
                switch (type) {
                    case "Vegetable": {
                        Food vegetable = new Vegetable(quantity);
                        Animal animal = animals.get(animals.size() - 1);
                        animal.eatFood(vegetable);
                        break;
                    }
                    case "Meat":
                        Food meat = new Meat(quantity);
                        Animal animal = animals.get(animals.size() - 1);
                        animal.eatFood(meat);
                        break;
                }

            }
            line = scanner.nextLine();
            index++;
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }
}
