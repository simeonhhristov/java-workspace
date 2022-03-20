package com.example.week4task4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBinary;

    @FXML
    private Button btnDecimal;

    @FXML
    private Button btnHex;

    @FXML
    private MenuItem mniBinary;

    @FXML
    private MenuItem mniDecimal;

    @FXML
    private MenuItem mniHex;

    @FXML
    private Menu mnuConvert;

    @FXML
    private Menu mnuQuit;

    @FXML
    private TextField txtBinary;

    @FXML
    private TextField txtDecimal;

    @FXML
    private TextField txtHex;

    @FXML
    void btnBinaryOnActionHandler(ActionEvent event) {
        convertBinary();
    }

    @FXML
    void btnDecimalOnActionHandler(ActionEvent event) {
        convertDecimal();
    }

    @FXML
    void btnHexOnActionHandler(ActionEvent event) {
        convertHex();
    }

    @FXML
    void mniBinaryOnActionHandler(ActionEvent event) {
        convertBinary();
    }

    @FXML
    void mniDecimalOnActionHandler(ActionEvent event) {
        convertDecimal();
    }

    @FXML
    void mniHexOnActionHandler(ActionEvent event) {
        convertHex();
    }

    @FXML
    void mnuQuitOnActionHandler(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void txtBinaryOnActionHandler(ActionEvent event) {
        convertBinary();
    }

    @FXML
    void txtDecimalOnActionHandler(ActionEvent event) {
        convertDecimal();
    }

    @FXML
    void txtHexOnActionHandler(ActionEvent event) {
        convertHex();
    }

    @FXML
    void initialize() {
        assert btnBinary != null : "fx:id=\"btnBinary\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnDecimal != null : "fx:id=\"btnDecimal\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnHex != null : "fx:id=\"btnHex\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mniBinary != null : "fx:id=\"mniBinary\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mniDecimal != null : "fx:id=\"mniDecimal\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mniHex != null : "fx:id=\"mniHex\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mnuConvert != null : "fx:id=\"mnuConvert\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mnuQuit != null : "fx:id=\"mnuQuit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtBinary != null : "fx:id=\"txtBinary\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtDecimal != null : "fx:id=\"txtDecimal\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtHex != null : "fx:id=\"txtHex\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

    private void convertDecimal() {
        String decimalText = txtDecimal.getText();
        int decimal = Integer.parseInt(decimalText);
        txtHex.setText(Integer.toHexString(decimal).toUpperCase());
        txtBinary.setText(Integer.toBinaryString(decimal));
    }

    private void convertHex() {
        String hexText = txtHex.getText();
        int decimal = Integer.parseInt(hexText, 16);
        txtDecimal.setText(Integer.toString(decimal));
        txtBinary.setText(Integer.toBinaryString(decimal));
    }

    private void convertBinary() {
        String binaryText = txtBinary.getText();
        int decimal = Integer.parseInt(binaryText, 2);
        txtDecimal.setText(Integer.toString(decimal));
        txtHex.setText(Integer.toHexString(decimal));
    }
}
