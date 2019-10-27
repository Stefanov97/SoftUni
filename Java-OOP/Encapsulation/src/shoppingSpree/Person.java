package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + " - ");
        if (this.products.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            List<Product> products1 = this.products;
            for (int i = 0; i < products1.size(); i++) {
                Product product = products1.get(i);
                if (i == products1.size() - 1) {
                    sb.append(product.getName());
                } else {
                    sb.append(product.getName() + ", ");
                }
            }
        }
        return sb.toString().trim();
    }
}
