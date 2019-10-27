package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        validateParam(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateParam(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateParam(height, "Height");
        this.height = height;
    }

    private void validateParam(double param, String type) {
        if (param <= 0) {
            throw new IllegalArgumentException(type + " cannot be zero ot negative.");
        }
    }

    public double calculateSurfaceArea() {
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * this.length * this.height) + 2 * (this.width * this.height);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
