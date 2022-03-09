module com.example.week2zad2drawlines {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week2zad2drawlines to javafx.fxml;
    exports com.example.week2zad2drawlines;
}