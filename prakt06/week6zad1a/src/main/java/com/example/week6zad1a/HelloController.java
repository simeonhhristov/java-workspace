package com.example.week6zad1a;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGcd;

    @FXML
    private Button btnQuit;

    @FXML
    private Label lblA;

    @FXML
    private Label lblB;

    @FXML
    private Label lblGcd;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtGcd;

    @FXML
    void btnOnActionHandlerQuit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnOnActonHandlerGcd(ActionEvent event) {
        int a = Integer.parseInt(txtA.getText());
        int b = Integer.parseInt(txtB.getText());
        int gcd = computeGcd(a,b);
        txtGcd.setText(Integer.toString(gcd));
    }



    @FXML
    void initialize() {
        assert btnGcd != null : "fx:id=\"btnGcd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblA != null : "fx:id=\"lblA\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblB != null : "fx:id=\"lblB\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblGcd != null : "fx:id=\"lblGcd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtA != null : "fx:id=\"txtA\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtB != null : "fx:id=\"txtB\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtGcd != null : "fx:id=\"txtGcd\" was not injected: check your FXML file 'hello-view.fxml'.";

    }
    private int computeGcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return computeGcd(b, a % b);
    }
}
