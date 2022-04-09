package com.example.week7task1cgeometrytest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.example.geometry.*;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 300, 300); // Create the scene

        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            double x = random.nextInt(101);
            double y = random.nextInt(101);
            double width = 1 + random.nextInt(200);
            double height = 1 + random.nextInt(200);
            Rectangle rectangle = new Rectangle(new Point(new double[]{x,y}), width, height);
            rectangle.draw(group);
            drawDiagonals(rectangle, group);
        }



        //Set the title of the Stage(the application window)
        stage.setTitle("Geometry");
        //Add the scene to the Stage
        stage.setScene(scene);
        //Show the Stage (the application window)
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private  void drawDiagonals(Rectangle rectangle, Group group){
        double upperLeftX = rectangle.getUPoint().getCoordinates()[0];
        double upperLeftY = rectangle.getUPoint().getCoordinates()[1];

        Point upperLeft = rectangle.getUPoint();
        Point lowerLeft = new Point(new double[]{upperLeftX, upperLeftY + rectangle.getHeight()});
        Point upperRight = new Point(new double[]{upperLeftX + rectangle.getWidth(), upperLeftY });
        Point lowerRight = new Point(new double[]{upperLeftX + rectangle.getWidth(), upperLeftY + rectangle.getHeight()});

        Line firstDiagonal  = new Line(upperLeft, lowerRight);
        Line secondDiagonal = new Line(upperRight, lowerLeft);

        firstDiagonal.draw(group);
        secondDiagonal.draw(group);
    }
}