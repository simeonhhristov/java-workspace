module com.example.newgametest {
    requires javafx.controls;
    requires javafx.fxml;
    requires NewGameLib;


    opens gui to javafx.fxml;
    exports gui;
}