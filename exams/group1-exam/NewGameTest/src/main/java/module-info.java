module com.example.newgametest {
    requires javafx.controls;
    requires javafx.fxml;
    requires NewGameLib;


    opens com.example.newgametest to javafx.fxml;
    exports com.example.newgametest;
}