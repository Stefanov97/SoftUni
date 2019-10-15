public class Car {
    private String make;
    private String model;
    private int horsePower;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void getInfo() {
        System.out.println(String.format("The car is: %s %s - %d HP.", this.make, this.model, this.horsePower));
    }
}
