package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(2 * (this.height + this.width));
    }

    @Override
    public void calculateArea() {
        this.setArea(this.height * this.width);
    }
}
