package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;

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
    private Button btnSignUp;

    @FXML
    private Label lblEmailErr;

    @FXML
    private Label lblNamesErr;

    @FXML
    private Label lblPasswordErr;

    @FXML
    private Label lblPhoneNumberErr;

    @FXML
    private Label lblRepeatPasswordErr;

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNames;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtRepeatPassword;

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        lblResult.setText("");

        if (isValidInput()) {
            lblResult.setText("Signed Up successfully");
        }
    }

    @FXML
    void initialize() {
        assert btnSignUp != null : "fx:id=\"btnSignUp\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblEmailErr != null : "fx:id=\"lblEmailErr\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblNamesErr != null : "fx:id=\"lblNamesErr\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblPasswordErr != null : "fx:id=\"lblPasswordErr\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblPhoneNumberErr != null : "fx:id=\"lblPhoneNumberErr\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblRepeatPasswordErr != null : "fx:id=\"lblRepeatPasswordErr\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblResult != null : "fx:id=\"lblResult\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtNames != null : "fx:id=\"txtNames\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtPhoneNumber != null : "fx:id=\"txtPhoneNumber\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtRepeatPassword != null : "fx:id=\"txtRepeatPassword\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

    boolean isValidInput() {
        boolean name = correctName();
        boolean phone = correctPhoneNumber();
        boolean email = correctEmail();
        boolean password = correctPassword();
        boolean matching = matchingPasswords();

        return name && phone && email && password && matching;
    }


    boolean correctName() {
        String tmp = txtNames.getText();
        if (!tmp.matches("[a-zA-Z]{2,}")) {
            lblNamesErr.setText("Invalid name. It should contain only letters a- z (upper or lower case) and at least 2 such letters");
            return false;
        }

        lblNamesErr.setText("");
        return true;
    }

    boolean correctPhoneNumber() {
        String tmp = txtPhoneNumber.getText();
        if (!tmp.matches("\\(\\d{4}\\) \\(\\d{7}\\)")) {
            lblPhoneNumberErr.setText("Invalid number.  It should be of the format (9999) (9999999)");
            return false;
        }

        lblPhoneNumberErr.setText("");
        return true;
    }

    boolean correctEmail() {
        String tmp = txtEmail.getText();
        if (!tmp.matches("(\\w+[.]?-?)+@(\\w+-?)+[.][a-zA-Z]{2,4}")) {
            lblEmailErr.setText("Invalid email.");
            return false;
        }
        lblEmailErr.setText("");
        return true;
    }

    boolean correctPassword() {
        if (txtPassword.getText().length() < 8) {
            lblPasswordErr.setText("Password must be 8 or more characters.");
            return false;
        }
        lblPasswordErr.setText("");
        return true;
    }

    boolean matchingPasswords() {
        if (!txtPassword.getText().equals(txtRepeatPassword.getText())) {
            lblRepeatPasswordErr.setText("Passwords do not match.");
            return false;
        }
        return true;
    }
}
