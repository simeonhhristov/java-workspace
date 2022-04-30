module com.example.gametest {
    requires javafx.controls;
    requires javafx.fxml;
    requires CardsGameLib;


    opens gui to javafx.fxml;
    exports gui;
}