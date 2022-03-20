module com.example.week4task4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week4task4 to javafx.fxml;
    exports com.example.week4task4;
}