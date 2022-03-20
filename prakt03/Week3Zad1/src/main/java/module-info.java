module com.example.week3zad1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week3zad1 to javafx.fxml;
    exports com.example.week3zad1;
}