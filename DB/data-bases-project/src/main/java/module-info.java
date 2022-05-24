module com.example.databasesproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires db2jcc4;


    opens com.example.databasesproject to javafx.fxml;
    exports com.example.databasesproject;
}