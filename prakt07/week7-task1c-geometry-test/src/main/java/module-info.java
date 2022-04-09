module com.example.week7task1cgeometrytest {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.example.week07task01;


    opens com.example.week7task1cgeometrytest to javafx.fxml;
    exports com.example.week7task1cgeometrytest;
}