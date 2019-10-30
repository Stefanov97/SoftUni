package shapes;

public class Circle extends Shape {
    private Double radius;

    public final Double getRadius() {
        return radius;
    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        this.setArea(Math.PI * Math.pow(radius, 2));
    }
}
