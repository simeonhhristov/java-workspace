module com.example.task1week3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task1week3 to javafx.fxml;
    exports com.example.task1week3;
}