package com.example.task1week3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.IllegalFormatWidthException;
import java.util.Optional;

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
        circle.setStroke(Color.RED);
        group.getChildren().add(circle);

        double lineX = getLineX(scene.getWidth());
        Line line = new Line(lineX, 0, lineX, scene.getHeight());
        line.setStroke(Color.BLUE);
        group.getChildren().add(line);
        double chSquare = radius * radius - (centerX - lineX) * (centerX - lineX);

        if (chSquare >= 0){
            double firstCrossPointY = centerY - Math.sqrt(chSquare);
            drawSmallCircleWithText(lineX, firstCrossPointY, group);
            if (chSquare > 0){
                double secondCrossPointY = centerY + Math.sqrt(chSquare);
                drawSmallCircleWithText(lineX, secondCrossPointY, group);
            }
        }else {
            showWarningAlert();
            Platform.exit();
        }
        // Set the title of the Stage(the application window)
        stage.setTitle("Draw Circle with Line");
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Show the Stage (the application window)
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private double getLineX(double width) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setContentText("Enter x for line AB");

        double x = 0;
        boolean invalid = true;

        do {
            Optional<String> userInput = dialog.showAndWait();
            if (userInput.isPresent()) {
                x = Double.parseDouble(userInput.get());

                if (x >= 0 && x <= width) {
                    invalid = false;
                } else{
                    showErrorAlert(width);
                }
            } else {
                invalid = false;
            }
        }while (invalid);

        return x;
    }
    private void showWarningAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("No intersection.");
        alert.showAndWait();
    }
    private  void drawSmallCircleWithText(double x, double y, Group group){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        Circle circle = new Circle(x,y, 5);
  //      Text text = new Text(x + 10, y, numberFormat.format(x) + ", " + numberFormat.format(y) + ")" );
        Text text = new Text(x + 10, y, String.format("(%.2f, %.2f)", x, y));
        group.getChildren().add(circle);
        group.getChildren().add(text);
    }

    private void showErrorAlert(double width)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText(String.format("Enter x within bounds [0; %.2f]", width));
        alert.showAndWait();
    }


}