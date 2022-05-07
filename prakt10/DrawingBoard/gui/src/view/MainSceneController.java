package view;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainSceneController {
    private Random random;
    private double width;
    private  double height;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDrawLine;

    @FXML
    private Button btnDrawrRectangle;

    @FXML
    private Pane pnlDrawingBoard;

    @FXML
    void btnDrawLineOnAction(ActionEvent event) {
        width = pnlDrawingBoard.getWidth();
        height = pnlDrawingBoard.getHeight();

        Point sPoint = new Point(new int[]{
               (int) (width * random.nextDouble()),
                (int) (height * random.nextDouble())
        });

        Point ePoint = new Point(new int[]{
                (int) (width * random.nextDouble()),
                (int) (height * random.nextDouble())
        });

        Line line = new Line(sPoint, ePoint);
        line.draw(pnlDrawingBoard);
    }

    @FXML
    void btnDrawrRectangleOnAction(ActionEvent event) {
        width = pnlDrawingBoard.getWidth();
        height = pnlDrawingBoard.getHeight();

        Point uPoint = new Point(new int[]{
                (int) (width * random.nextDouble()),
                (int) (height * random.nextDouble())
        });

        Point lPoint = new Point(new int[]{
                (int) (width * random.nextDouble()),
                (int) (height * random.nextDouble())
        });

        Rectangle rectangle = new Rectangle(uPoint, lPoint);
        rectangle.draw(pnlDrawingBoard);

    }

    @FXML
    void initialize() {
        assert btnDrawLine != null : "fx:id=\"btnDrawLine\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert btnDrawrRectangle != null : "fx:id=\"btnDrawrRectangle\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert pnlDrawingBoard != null : "fx:id=\"pnlDrawingBoard\" was not injected: check your FXML file 'MainScene.fxml'.";
        random = new Random();
    }
}
