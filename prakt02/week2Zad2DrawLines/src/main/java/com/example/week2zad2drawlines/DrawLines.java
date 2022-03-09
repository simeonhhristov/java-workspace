package com.example.week2zad2drawlines;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawLines extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 300, 250);// Create the Scene

    // add content to the Layout panel
        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scene
        double radius = 10;
        for (int i = 0; i < 12; i++) {
            Circle circle = new Circle(width / 2, height / 2, radius);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);
            group.getChildren().add(circle);
            radius += 10;
        }
    // Set the title of the Stage(the application window)
        primaryStage.setTitle("Drawing shapes");
    // Add the Scene to the Stage
        primaryStage.setScene(scene);
        // Show the Stage (the application window)
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}