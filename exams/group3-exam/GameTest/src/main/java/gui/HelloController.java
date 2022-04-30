package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.StackOfCards;

public class HelloController {
    StackOfCards game = new StackOfCards();

    @FXML
    private Button btnDraw;

    @FXML
    private Button btnFourAce;

    @FXML
    private Button btnPairKQ;

    @FXML
    private Button btnQuit;

    @FXML
    private TextArea tarCombinations;

    @FXML
    private TextArea tarHand;

    @FXML
    void onActionHandlerFourAce(ActionEvent event) {

    }

    @FXML
    void onActionHandlerKQ(ActionEvent event) {

    }

    @FXML
    void onActionHandlerQuit(ActionEvent event) {

    }

    @FXML
    void onDrawActionHandler(ActionEvent event) {
        game.shuffleCards();
        game.make2packs();

        tarHand.setText(game.printCards());
    }

}
