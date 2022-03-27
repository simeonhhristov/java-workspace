module com.example.snail {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snail to javafx.fxml;
    exports com.example.snail;
}