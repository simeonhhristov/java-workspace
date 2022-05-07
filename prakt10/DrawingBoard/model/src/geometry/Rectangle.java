package geometry;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Rectangle extends Point {
    private Point lPoint;

    public Rectangle(Point uPoint, Point lPoint) {
        setPoint(uPoint);
        setLPoint(lPoint);
    }

    public Rectangle() {
        this(new Point(), new Point(new int[]{1, 1}));
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.getPoint(), rectangle.lPoint);
    }

    public Point getLPoint() {
        return new Point(lPoint);
    }

    public void setLPoint(Point uPoint) {
        if (uPoint != null) {
            this.lPoint = new Point(uPoint);
        } else {
            this.lPoint = new Point();
        }
    }

    public double getWidth() {
        int startX = getPoint().getCoordinates()[0];
        int endX = lPoint.getCoordinates()[0];
        return Math.abs(startX - endX);
    }

    public double getHeight() {
        int startY = getPoint().getCoordinates()[1];
        int endY = lPoint.getCoordinates()[1];
        return Math.abs(startY - endY);
    }

    public void draw(Pane pane) {
        int x = lPoint.getCoordinates()[0];
        int y = lPoint.getCoordinates()[1];
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(x, y, getWidth(), getHeight());
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        pane.getChildren().add(rectangle);
    }

    public  double measure(){
        return  2 * (getHeight() +  getWidth());
    }


    @Override
    public String toString() {
        return String.format("Point: %s, width: %.2f, height: %.2f", lPoint.toString(), getWidth(), getHeight());
    }
}
