module com.example.calendar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calendar to javafx.fxml;
    exports com.example.calendar;
}