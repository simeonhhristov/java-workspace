module com.example.week6zad1a {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week6zad1a to javafx.fxml;
    exports com.example.week6zad1a;
}