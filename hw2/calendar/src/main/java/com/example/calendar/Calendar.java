package com.example.calendar;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Optional;

import static javafx.scene.text.TextAlignment.CENTER;
import static javafx.scene.text.TextAlignment.RIGHT;

public class Calendar extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 350, 250); // Create the scene

        double width = scene.getWidth();
        double height = scene.getHeight();

        //set horizontal spacing between days
        double marginX = width / 9;
        //set vertical spacing between days
        double marginY = height / 9;

        //prompt user to select month and year
        int month = getMonth();
        int year = getYear();

        //print different week days
        Text text;
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        for (int i = 1; i <= 7; i++) {
            text = generateText(i * marginX, marginY, Color.BLACK, days[i - 1]);
            group.getChildren().add(text);
        }

        //get number of days for the selected month
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();

        //lines on which to print dates
        double line = marginY * 2;

        //print dates
        for (int i = 1; i <= daysInMonth; i++) {
            LocalDate date = LocalDate.of(year, month, i);

            //get dates
            text = generateDateText(1 * marginX, line, date, i);
            group.getChildren().add(text);

            //if last date was a sunday go to next line
            if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                line += marginY;
            }
        }

        //Set the title of the Stage(the application window)
        stage.setTitle("Title");
        //Add the scene to the Stage
        stage.setScene(scene);
        //Show the Stage (the application window)
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }

    private int getMonth() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Month");
        dialog.setContentText("Enter number of month");

        int month = 0;
        boolean invalid = true;

        do {
            Optional<String> userInput = dialog.showAndWait();
            if (userInput.isPresent()) {
                month = Integer.parseInt(userInput.get());

                if (month <= 0 || month > 12) {
                    showAlert();
                } else {
                    invalid = false;
                }
            } else {
                invalid = false;
            }
        } while (invalid);

        return month;
    }

    private int getYear() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Year");
        dialog.setContentText("Enter year");

        int year = 0;
        Optional<String> userInput = dialog.showAndWait();
        if (userInput.isPresent()) {
            year = Integer.parseInt(userInput.get());
        } else {
            Platform.exit();
        }

        return year;
    }

    private Text generateText(double xCoord, double yCoord, Color color, String data) {
        Text text = new Text(xCoord, yCoord, data);
        text.setStroke(color);
        text.setFill(color);

        return text;
    }

    private Text generateDateText(double xCoord, double yCoord, LocalDate date, int day) {

        //set color to red if present day is in the month
        Color color = Color.BLACK;
        if (date.equals(LocalDate.now())) {
            color = Color.RED;
        }

        Text text;

        switch (date.getDayOfWeek()) {
            case MONDAY:
                text = generateText(xCoord, yCoord, color, Integer.toString(day));
                return text;
            case TUESDAY:
                text = generateText(2 * xCoord, yCoord, color, Integer.toString(day));
                return text;
            case WEDNESDAY:
                text = generateText(3 * xCoord, yCoord, color, Integer.toString(day));
                return text;
            case THURSDAY:
                text = generateText(4 * xCoord, yCoord, color, Integer.toString(day));
                return text;
            case FRIDAY:
                text = generateText(5 * xCoord, yCoord, color, Integer.toString(day));
                return text;
            case SATURDAY:
                text = generateText(6 * xCoord, yCoord, color, Integer.toString(day));
                return text;
            case SUNDAY:
                text = generateText(7 * xCoord, yCoord, color, Integer.toString(day));
                return text;
            default:
                text = new Text("0");
        }
        return text;
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(String.format("Enter a valid month."));
        alert.showAndWait();
    }


}