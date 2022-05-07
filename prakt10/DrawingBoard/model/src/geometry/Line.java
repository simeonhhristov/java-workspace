package geometry;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Line extends Point{
    private Point ePoint;

    public Line(Point sPoint, Point ePoint) {
        setSPoint(sPoint);
        setEPoint(ePoint);
    }

    public Line() {
        this(new Point(), new Point());
    }

    public Line(Line line) {
        this(line.getPoint(), line.ePoint);
    }

    public Point getSPoint() {
        return getPoint();
    }

    public void setSPoint(Point sPoint) {
        setPoint(sPoint);
    }

    public Point getEPoint() {
        return new Point(ePoint);
    }

    public void setEPoint(Point ePoint) {
        if (ePoint != null) {
            this.ePoint = new Point(ePoint);
        } else {
            this.ePoint = new Point();
        }
    }

    public void draw(Pane pane) {
        int startX = getPoint().getCoordinates()[0];
        int startY = getPoint().getCoordinates()[1];
        int endX = ePoint.getCoordinates()[0];
        int endY = ePoint.getCoordinates()[1];
        javafx.scene.shape.Line line = new javafx.scene.shape.Line(startX, startY, endX, endY);
        line.setStroke(Color.BLUE);
        pane.getChildren().add(line);
    }

    public double measure(){
        int startX = getPoint().getCoordinates()[0];
        int startY = getPoint().getCoordinates()[1];
        int endX = ePoint.getCoordinates()[0];
        int endY = ePoint.getCoordinates()[1];

        return Math.sqrt((startX - endX) *(startX - endX) + (startY - endY) * (startY - endY));
    }

    @Override
    public String toString() {
        return String.format("sPoint: %s, ePoint: %s", getPoint().toString(), ePoint.toString());
    }
}
