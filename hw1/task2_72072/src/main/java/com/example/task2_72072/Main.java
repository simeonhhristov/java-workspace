package com.example.task2_72072;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class Main extends Application {
    public QuadCurve generateCurve(double startX, double startY, double controlX, double controlY, double endX, double endY) {
        QuadCurve curve = new QuadCurve(startX, startY, controlX, controlY, endX, endY);
        curve.setStroke(Color.web("3fb07d"));
        curve.setFill(Color.TRANSPARENT);
        curve.setStrokeWidth(0.5);

        return curve;
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 550, 450);// Create the Scene

        // add content to the Layout panel
        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scene

        int numberOfLines = 15;

        //define curve spacing for each axle
        double spacingX = (width / numberOfLines);
        double spacingY = (height / numberOfLines);

        for (int i = 1; i <= numberOfLines; i++) {
            //generate top left going down
            group.getChildren().add(generateCurve(0, 0, 0, height, spacingX * i, height));
            //generate  top left going right
            group.getChildren().add(generateCurve(0, 0, width, 0, width, spacingY * i));

            //generate bottom right going left
            group.getChildren().add(generateCurve(width, height, 0, height, 0, height - spacingY * i));
            //generate bottom right going up
            group.getChildren().add(generateCurve(width, height, width, 0, width - spacingX * i, 0));

            //generate bottom left going up
            group.getChildren().add(generateCurve(0, height, 0, 0, spacingX * i, 0));
            //generate bottom left going right
            group.getChildren().add(generateCurve(0, height, width, height, width, height - spacingY * i));

            //generate top right going left
            group.getChildren().add(generateCurve(width, 0, 0, 0, 0, spacingY * i));
            //generate top right going down
            group.getChildren().add(generateCurve(width, 0, width, height, width - spacingX * i, height));
        }

        // Set the title of the Stage(the application window)
        primaryStage.setTitle("Drawing");
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        // Show the Stage (the application window)
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}