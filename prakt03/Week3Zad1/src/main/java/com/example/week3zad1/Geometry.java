package com.example.week3zad1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Geometry extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 300, 250);// Create the Scene



        double centerX = scene.getWidth() / 2;
        double centerY =  scene.getHeight() /2;

        double radius = Math.min(scene.getWidth(),scene.getHeight()) / 3;

        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);

        group.getChildren().add(circle);

        // Set the title of the Stage(the application window)
        stage.setTitle("Draw Circle with Line");
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Show the Stage (the application window)
    }

    public static void main(String[] args) {
        launch();
    }
}