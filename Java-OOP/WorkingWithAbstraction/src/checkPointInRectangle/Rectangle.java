package checkPointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {

        boolean isXInBounds = checkX(point);
        boolean isYInBounds = checkY(point);

        return isXInBounds && isYInBounds;
    }

    private boolean checkY(Point point) {
        return point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
    }

    private boolean checkX(Point point) {
        return point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX();
    }
}
