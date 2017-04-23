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
    static Group root;
    static Scene theScene;
    Canvas canvas;
    GraphicsContext gc;
    Image wbg;
    Image wpawn ;
    Image wrook ;
    Image wbishop ;
    Image wknight ;
    Image wking ;
    Image wqueen ;
    Image bbg;
    Image bpawn ;
    Image brook ;
    Image bbishop ;
    Image bknight ;
    Image bking ;
    Image bqueen ;

    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        theScene = new Scene(root);
        primaryStage.setScene(theScene);

        canvas = new Canvas(1600, 800);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();


        CreatePieces();
        CreateBoard();

        primaryStage.show();
        String origin;
        String destination;
        origin = "a2";
        destination = "a3";
        ChessBoard gameBoard = new ChessBoard();
        gameBoard.SetGui(this);
        gameBoard.Set();
        gameBoard.Display();
        gameBoard.MovePiece( origin,  destination);
    }
    public boolean SetThis(Image thisImage, int x, int y){

        gc.drawImage(thisImage, x, y);
       return true;
    }
    public void CreateBoard(){
        gc.drawImage(wbg, 0, 0);
        gc.drawImage(bbg, 100, 0);
        gc.drawImage(wbg, 200, 0);
        gc.drawImage(bbg, 300, 0);
        gc.drawImage(wbg, 400, 0);
        gc.drawImage(bbg, 500, 0);
        gc.drawImage(wbg, 600, 0);
        gc.drawImage(bbg, 700, 0);
        gc.drawImage(bbg, 0, 100);
        gc.drawImage(wbg, 100, 100);
        gc.drawImage(bbg, 200, 100);
        gc.drawImage(wbg, 300, 100);
        gc.drawImage(bbg, 400, 100);
        gc.drawImage(wbg, 500, 100);
        gc.drawImage(bbg, 600, 100);
        gc.drawImage(wbg, 700, 100);

        gc.drawImage(wbg, 0, 200);
        gc.drawImage(bbg, 100, 200);
        gc.drawImage(wbg, 200, 200);
        gc.drawImage(bbg, 300, 200);
        gc.drawImage(wbg, 400, 200);
        gc.drawImage(bbg, 500, 200);
        gc.drawImage(wbg, 600, 200);
        gc.drawImage(bbg, 700, 200);
        gc.drawImage(bbg, 0, 300);
        gc.drawImage(wbg, 100, 300);
        gc.drawImage(bbg, 200, 300);
        gc.drawImage(wbg, 300, 300);
        gc.drawImage(bbg, 400, 300);
        gc.drawImage(wbg, 500, 300);
        gc.drawImage(bbg, 600, 300);
        gc.drawImage(wbg, 700, 300);

        gc.drawImage(wbg, 0, 400);
        gc.drawImage(bbg, 100, 400);
        gc.drawImage(wbg, 200, 400);
        gc.drawImage(bbg, 300, 400);
        gc.drawImage(wbg, 400, 400);
        gc.drawImage(bbg, 500, 400);
        gc.drawImage(wbg, 600, 400);
        gc.drawImage(bbg, 700, 400);
        gc.drawImage(bbg, 0, 500);
        gc.drawImage(wbg, 100, 500);
        gc.drawImage(bbg, 200, 500);
        gc.drawImage(wbg, 300, 500);
        gc.drawImage(bbg, 400, 500);
        gc.drawImage(wbg, 500, 500);
        gc.drawImage(bbg, 600, 500);
        gc.drawImage(wbg, 700, 500);

        gc.drawImage(wbg, 0, 600);
        gc.drawImage(bbg, 100, 600);
        gc.drawImage(wbg, 200, 600);
        gc.drawImage(bbg, 300, 600);
        gc.drawImage(wbg, 400, 600);
        gc.drawImage(bbg, 500, 600);
        gc.drawImage(wbg, 600, 600);
        gc.drawImage(bbg, 700, 600);
        gc.drawImage(bbg, 0, 700);
        gc.drawImage(wbg, 100, 700);
        gc.drawImage(bbg, 200, 700);
        gc.drawImage(wbg, 300, 700);
        gc.drawImage(bbg, 400, 700);
        gc.drawImage(wbg, 500, 700);
        gc.drawImage(bbg, 600, 700);
        gc.drawImage(wbg, 700, 700);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    public void CreatePieces(){

        bbg = new Image("bbg.gif", 130, 130, true, false);
        bpawn  = new Image("bpawn.gif", 100, 100, true, false);
        brook  = new Image("brook.gif", 100, 100, true, false);
        bbishop  = new Image("bbishop.gif", 100, 100, true, false);
        bknight  = new Image("bknight.gif", 100, 100, true, false);
        bking  = new Image("bking.gif", 100, 100, true, false);
        bqueen = new Image("bqueen.gif", 100, 100, true, false);


        wbg = new Image("wbg.gif", 110, 110, true, false);
        wpawn  = new Image("wpawn.gif", 100, 100, true, false);
        wrook  = new Image("wrook.gif", 100, 100, true, false);
        wbishop  = new Image("wbishop.gif", 100, 100, true, false);
        wknight  = new Image("wknight.gif", 100, 100, true, false);
        wking  = new Image("wking.gif", 100, 100, true, false);
        wqueen = new Image("wqueen.gif", 100, 100, true, false);

    }


}
