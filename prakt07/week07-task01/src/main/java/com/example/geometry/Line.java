package com.example.geometry;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Line {
    private  Point sPoint;
    private  Point ePoint;

    public Line(Point sPoint, Point ePoint) {
        setSPoint(sPoint);
        setEPoint(ePoint);
    }
    public Line() {
        this(new Point(), new Point());
    }
    public Line(Line line) {
        this(line.sPoint, line.ePoint);
    }

    public Point getSPoint() {
        return new Point(sPoint);
    }

    public void setSPoint(Point sPoint) {
        if(sPoint != null) {
            this.sPoint = new Point(sPoint);
            return;
        }
        this.sPoint = new Point();
    }

    public Point getEPoint() {
        return new Point(ePoint);
    }

    public void setEPoint(Point ePoint) {
        if(ePoint != null) {
            this.ePoint = new Point(ePoint);
            return;
        }
        this.ePoint = new Point();
    }
    public void draw(Group pane)
    {
        double startX = sPoint.getCoordinates()[0];
        double startY = sPoint.getCoordinates()[1];
        double endX = ePoint.getCoordinates()[0];
        double endY = ePoint.getCoordinates()[1];

        javafx.scene.shape.Line line = new javafx.scene.shape.Line(startX, startY, endX, endY);
        line.setStroke(Color.BLUE);
        pane.getChildren().add(line);

    }

    @Override
    public String toString() {
        return String.format("sPoint: %s, ePoint: %s", sPoint, ePoint);
    }
}
