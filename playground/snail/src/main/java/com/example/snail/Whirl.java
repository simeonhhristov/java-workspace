package com.example.snail;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Whirl extends Application {
    public Line generateLine(double startX, double startY, double endX, double endY) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(Color.BLACK);
        line.setFill(Color.TRANSPARENT);
        line.setStrokeWidth(1.0);

        return line;
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 350, 350);// Create the Scene

        // add content to the Layout panel
        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scene

        int whirlDepth = 220;
        double spacing = height / (whirlDepth * 2 + 2);

        //rather than adding in a
        for (int i = 1; i <= whirlDepth; i++) {
            //generate top lines
            group.getChildren().add(generateLine(i*spacing, i*spacing, width - i * spacing, i* spacing));

            //generate left lines
            group.getChildren().add(generateLine(i*spacing, i*spacing, i * spacing, height - i* spacing));

            //generate bottom lines
            group.getChildren().add(generateLine(i*spacing, height - i*spacing, width - (i + 1) * spacing, height - i* spacing));

            //generate right lines
            group.getChildren().add(generateLine(width - (i + 1)*spacing, (i + 1)*spacing, width - (i + 1) * spacing , height - i* spacing));
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