package com.example.task2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HelloController extends AnchorPane {
    private double resultScreen = 0;
    private double currentScreen = 0;
    private char lastOperation = '\0';
    private boolean isSetDecimal = false;
    private int digitsBehindDot = 0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnClearCurr;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnEquals;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnInf;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnPoint;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnZero;

    @FXML
    private TextField txtScreen;

    @FXML
    void onActionHandlerClearAll(ActionEvent event) {
        this.resultScreen = 0;
        this.currentScreen = 0;
        this.lastOperation = '\0';
        this.isSetDecimal = false;
        this.digitsBehindDot = 0;
        txtScreen.setText("");
    }

    @FXML
    void onActionHandlerClearCurr(ActionEvent event) {
        this.currentScreen = 0;
        this.isSetDecimal = false;
        this.digitsBehindDot = 0;
        txtScreen.setText("");
    }

    @FXML
    void onActionHandlerEquals(ActionEvent event) {
        applyOperation('=');
        //show result
        txtScreen.setText(String.valueOf(resultScreen));
        //reset result screen
        this.resultScreen = 0;
    }

    @FXML
    void onActionHandlerDivide(ActionEvent event) {
        applyOperation('/');
    }

    @FXML
    void onActionHandlerMinus(ActionEvent event) {
        applyOperation('-');
    }

    @FXML
    void onActionHandlerMultiply(ActionEvent event) {
        applyOperation('*');
    }

    @FXML
    void onActionHandlerPlus(ActionEvent event) {
        applyOperation('+');
    }

    private void applyOperation(char newOperation) {
        switch (this.lastOperation) {
            case '+' -> this.resultScreen += this.currentScreen;
            case '-' -> this.resultScreen -= this.currentScreen;
            case '*' -> this.resultScreen *= this.currentScreen;
            case '/' -> this.resultScreen /= this.currentScreen;

            // No operation means it's the initial input
            default -> {
                this.resultScreen = this.currentScreen;
            }
        }
        //reset decimalPart
        this.isSetDecimal = false;
        this.digitsBehindDot = 0;
        //set next operation
        this.lastOperation = newOperation;
        //prepare currentScreen for next input
        this.currentScreen = 0;
    }

    @FXML
    void onActionHandlerPoint(ActionEvent event) {
        this.isSetDecimal = true;
    }

    void appendDigit(int digit) {
        this.currentScreen *= 10;
        this.currentScreen += digit;
    }
    void appendDecimal(int digit){
        this.digitsBehindDot++;
        this.currentScreen += (double)digit / Math.pow(10, this.digitsBehindDot);
    }

    @FXML
    void onActionHandlerOne(ActionEvent event) {

        if (this.isSetDecimal) {
            appendDecimal(1);
        } else {
            appendDigit(1);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerTwo(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(2);
        } else {
            appendDigit(2);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerThree(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(3);
        } else {
            appendDigit(3);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerFour(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(4);
        } else {
            appendDigit(4);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerFive(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(5);
        } else {
            appendDigit(5);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerSix(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(6);
        } else {
            appendDigit(6);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerSeven(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(7);
        } else {
            appendDigit(7);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerEight(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(8);
        } else {
            appendDigit(8);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerNine(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(9);
        } else {
            appendDigit(9);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerZero(ActionEvent event) {
        if (this.isSetDecimal) {
            appendDecimal(0);
        } else {
            appendDigit(0);
        }
        txtScreen.setText(String.valueOf(this.currentScreen));
    }

    @FXML
    void onActionHandlerInf(ActionEvent event) {
        //00 button...
        //no idea what this is...
    }

    @FXML
    void onActionHandlerQuit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnClearCurr != null : "fx:id=\"btnClearCurr\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnInf != null : "fx:id=\"btnInf\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnPoint != null : "fx:id=\"btnPoint\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtScreen != null : "fx:id=\"txtScreen\" was not injected: check your FXML file 'hello-view.fxml'.";

        btnOne.setOnAction(this::onActionHandlerOne);
        btnTwo.setOnAction(this::onActionHandlerTwo);
        btnThree.setOnAction(this::onActionHandlerThree);
        btnFour.setOnAction(this::onActionHandlerFour);
        btnFive.setOnAction(this::onActionHandlerFive);
        btnSix.setOnAction(this::onActionHandlerSix);
        btnSeven.setOnAction(this::onActionHandlerSeven);
        btnEight.setOnAction(this::onActionHandlerEight);
        btnNine.setOnAction(this::onActionHandlerNine);
        btnZero.setOnAction(this::onActionHandlerZero);
        btnInf.setOnAction(this::onActionHandlerInf);

        btnMinus.setOnAction(this::onActionHandlerMinus);
        btnPlus.setOnAction(this::onActionHandlerPlus);
        btnMultiply.setOnAction(this::onActionHandlerMultiply);
        btnDivide.setOnAction(this::onActionHandlerDivide);
        btnEquals.setOnAction(this::onActionHandlerEquals);
        btnPoint.setOnAction(this::onActionHandlerPoint);

        btnClearCurr.setOnAction(this::onActionHandlerClearCurr);
        btnClearAll.setOnAction(this::onActionHandlerClearAll);

        btnQuit.setOnAction(this::onActionHandlerQuit);

    }

    public HelloController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
