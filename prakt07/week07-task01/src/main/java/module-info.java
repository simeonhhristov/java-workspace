module com.example.week07task01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.geometry to javafx.fxml;
    exports com.example.geometry;
}