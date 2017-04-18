package csu.csci325;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by mille on 4/13/2017.
 */
public class GUI extends Application {
    Group root;
    Scene theScene;
    Canvas canvas;
    GraphicsContext gc;
    Image bgw;
    Image bgb ;
    Image sun ;
    Image space;
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        theScene = new Scene(root);
        primaryStage.setScene(theScene);

        canvas = new Canvas(800, 800);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();

        ChessBoard gameBoard = new ChessBoard();
        gameBoard.Set();
        //gameBoard.Display();
        String origin;
        String destination;
        origin = "a2";
        destination = "a3";
        gameBoard.MovePiece( origin,  destination);

        bgw = new Image("DSC_7861.gif", 110, 110, true, false);

        bgb = new Image("DSC_7859.gif", 130, 130, true, false);
        sun = new Image("DSC_7863.gif", 100, 100, true, false);
        space = new Image("DSC_7864.gif", 100, 100, true, false);

        gc.drawImage(bgw, 0, 0);
        gc.drawImage(bgb, 100, 0);
        gc.drawImage(bgw, 200, 0);
        gc.drawImage(bgb, 300, 0);
        gc.drawImage(bgw, 400, 0);
        gc.drawImage(bgb, 500, 0);
        gc.drawImage(bgw, 600, 0);
        gc.drawImage(bgb, 700, 0);
        gc.drawImage(bgb, 0, 100);
        gc.drawImage(bgw, 100, 100);
        gc.drawImage(bgb, 200, 100);
        gc.drawImage(bgw, 300, 100);
        gc.drawImage(bgb, 400, 100);
        gc.drawImage(bgw, 500, 100);
        gc.drawImage(bgb, 600, 100);
        gc.drawImage(bgw, 700, 100);

        gc.drawImage(bgw, 0, 200);
        gc.drawImage(bgb, 100, 200);
        gc.drawImage(bgw, 200, 200);
        gc.drawImage(bgb, 300, 200);
        gc.drawImage(bgw, 400, 200);
        gc.drawImage(bgb, 500, 200);
        gc.drawImage(bgw, 600, 200);
        gc.drawImage(bgb, 700, 200);
        gc.drawImage(bgb, 0, 300);
        gc.drawImage(bgw, 100, 300);
        gc.drawImage(bgb, 200, 300);
        gc.drawImage(bgw, 300, 300);
        gc.drawImage(bgb, 400, 300);
        gc.drawImage(bgw, 500, 300);
        gc.drawImage(bgb, 600, 300);
        gc.drawImage(bgw, 700, 300);

        gc.drawImage(bgw, 0, 400);
        gc.drawImage(bgb, 100, 400);
        gc.drawImage(bgw, 200, 400);
        gc.drawImage(bgb, 300, 400);
        gc.drawImage(bgw, 400, 400);
        gc.drawImage(bgb, 500, 400);
        gc.drawImage(bgw, 600, 400);
        gc.drawImage(bgb, 700, 400);
        gc.drawImage(bgb, 0, 500);
        gc.drawImage(bgw, 100, 500);
        gc.drawImage(bgb, 200, 500);
        gc.drawImage(bgw, 300, 500);
        gc.drawImage(bgb, 400, 500);
        gc.drawImage(bgw, 500, 500);
        gc.drawImage(bgb, 600, 500);
        gc.drawImage(bgw, 700, 500);

        gc.drawImage(bgw, 0, 600);
        gc.drawImage(bgb, 100, 600);
        gc.drawImage(bgw, 200, 600);
        gc.drawImage(bgb, 300, 600);
        gc.drawImage(bgw, 400, 600);
        gc.drawImage(bgb, 500, 600);
        gc.drawImage(bgw, 600, 600);
        gc.drawImage(bgb, 700, 600);
        gc.drawImage(bgb, 0, 700);
        gc.drawImage(bgw, 100, 700);
        gc.drawImage(bgb, 200, 700);
        gc.drawImage(bgw, 300, 700);
        gc.drawImage(bgb, 400, 700);
        gc.drawImage(bgw, 500, 700);
        gc.drawImage(bgb, 600, 700);
        gc.drawImage(bgw, 700, 700);
        SetThis(sun, 0, 0);
        SetThis(space, 400, 0);
        primaryStage.show();
    }
    public boolean SetThis(Image thisImage, int x, int y){

        gc.drawImage(thisImage, x, y);
        return true;
    }

}
