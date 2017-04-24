package csu.csci325;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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

    boolean turn;

    static String origin="";
    static String destination="";

    ChessBoard gameBoard;
    public void start(Stage primaryStage) throws Exception {
        turn = true;
        root = new Group();
        theScene = new Scene(root);
        primaryStage.setScene(theScene);
        Button button = new Button("OK");

        canvas = new Canvas(1600, 800);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();

        theScene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse clicked on " + event.getX() + ", " + event.getY());
                //System.out.println(AlphaFromX(event.getX()));
                //System.out.println(Integer.toString(RowFromY(event.getY())));
                System.out.println("");
                if (turn  && origin.equals("")){
                    // set the origin
                    origin = AlphaFromX(event.getX()) + Integer.toString(RowFromY(event.getY()));
                    System.out.println( origin);
                }else if (turn  && destination.equals("")){
                    // set destination

                    System.out.println( destination);
                    destination = AlphaFromX(event.getX()) + Integer.toString(RowFromY(event.getY()));
                    if (gameBoard.MovePiece(origin, destination)== -1){
                        System.out.println("You cannot move here you already have a piece on that tile.");
                        // Scanner.nextLine();
                    }
                    gameBoard.MovePiece( origin,  destination);
                    RefreshBoard();
                    gameBoard.Display();
                    turn = false;
                    origin ="";
                    destination="";
                }else if (!turn  && origin.equals("")){
                    // set the origin
                    System.out.println( origin);
                    origin = AlphaFromX(event.getX()) + Integer.toString(RowFromY(event.getY()));
                }else{ //(!turn  && destination.equals("")){
                    // set destination
                    System.out.println( destination);
                    destination = AlphaFromX(event.getX()) + Integer.toString(RowFromY(event.getY()));
                    gameBoard.MovePiece( origin,  destination);
                    RefreshBoard();
                    gameBoard.Display();

                    turn = true;
                    origin ="";
                    destination="";
                }
            }
        });
        CreatePieces();
        CreateBoard();

        primaryStage.show();
        gameBoard = new ChessBoard();
        gameBoard.SetGui(this);
        gameBoard.Set();
        gameBoard.Display();
        /**
        origin = "a2";
        destination = "a3";
        gameBoard.MovePiece( origin,  destination);
         RefreshBoard();
        gameBoard.Display();
        **/
    }
    public boolean SetThis(Image thisImage, int x, int y){

        gc.drawImage(thisImage, x, y);
       return true;
    }
    public void RefreshBoard(){
        gc.restore();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        CreateBoard();


    }
public String AlphaFromX(double x){
    if (x < 100 *.75){
        return "A";
    } else if (x < 200 *.75){
        return "B";
    } else if (x < 300 *.75){
        return "C";
    } else if (x < 400 *.75){
        return "D";
    } else if (x < 500 *.75){
        return "E";
    } else if (x < 600 *.75){
        return "F";
    } else if (x < 700 *.75){
        return "G";
    } else if (x < 800 *.75){
        return "H";
    }

    return "";
}
    public int RowFromY(double y){
        if (y < 100 *.75){
            return 1;
        } else if (y < 200 *.75){
            return 2;
        } else if (y < 300 *.75){
            return 3;
        } else if (y < 400 *.75){
            return 4;
        } else if (y < 500 *.75){
            return 5;
        } else if (y < 600 *.75){
            return 6;
        } else if (y < 700 *.75){
            return 7;
        } else if (y < 800 *.75){
            return 8;
        }

        return -1;
    }
    public void CreateBoard(){
        gc.drawImage(wbg, 0, 0);
        gc.drawImage(bbg, 100*.75, 0);
        gc.drawImage(wbg, 200*.75, 0);
        gc.drawImage(bbg, 300*.75, 0);
        gc.drawImage(wbg, 400*.75, 0);
        gc.drawImage(bbg, 500*.75, 0);
        gc.drawImage(wbg, 600*.75, 0);
        gc.drawImage(bbg, 700*.75, 0);
        gc.drawImage(bbg, 0, 100*.75);
        gc.drawImage(wbg, 100*.75, 100 * .75);
        gc.drawImage(bbg, 200*.75, 100 * .75);
        gc.drawImage(wbg, 300*.75, 100 * .75);
        gc.drawImage(bbg, 400*.75, 100 * .75);
        gc.drawImage(wbg, 500*.75, 100 * .75);
        gc.drawImage(bbg, 600*.75, 100 * .75);
        gc.drawImage(wbg, 700*.75, 100 * .75);

        gc.drawImage(wbg, 0, 200 * .75);
        gc.drawImage(bbg, 100 * .75, 200 * .75);
        gc.drawImage(wbg, 200 * .75, 200 * .75);
        gc.drawImage(bbg, 300 * .75, 200 * .75);
        gc.drawImage(wbg, 400 * .75, 200 * .75);
        gc.drawImage(bbg, 500 * .75, 200 * .75);
        gc.drawImage(wbg, 600 * .75, 200 * .75);
        gc.drawImage(bbg, 700 * .75, 200 * .75);
        gc.drawImage(bbg, 0, 300 * .75);
        gc.drawImage(wbg, 100 * .75, 300 * .75);
        gc.drawImage(bbg, 200 * .75, 300 * .75);
        gc.drawImage(wbg, 300 * .75, 300 * .75);
        gc.drawImage(bbg, 400 * .75, 300 * .75);
        gc.drawImage(wbg, 500 * .75, 300 * .75);
        gc.drawImage(bbg, 600 * .75, 300 * .75);
        gc.drawImage(wbg, 700 * .75, 300 * .75);

        gc.drawImage(wbg, 0, 400 * .75);
        gc.drawImage(bbg, 100 * .75, 400 * .75);
        gc.drawImage(wbg, 200 * .75, 400 * .75);
        gc.drawImage(bbg, 300 * .75, 400 * .75);
        gc.drawImage(wbg, 400 * .75, 400 * .75);
        gc.drawImage(bbg, 500 * .75, 400 * .75);
        gc.drawImage(wbg, 600 * .75, 400 * .75);
        gc.drawImage(bbg, 700 * .75, 400 * .75);
        gc.drawImage(bbg, 0, 500 * .75);
        gc.drawImage(wbg, 100 * .75, 500 * .75);
        gc.drawImage(bbg, 200 * .75, 500 * .75);
        gc.drawImage(wbg, 300 * .75, 500 * .75);
        gc.drawImage(bbg, 400 * .75, 500 * .75);
        gc.drawImage(wbg, 500 * .75, 500 * .75);
        gc.drawImage(bbg, 600 * .75, 500 * .75);
        gc.drawImage(wbg, 700 * .75, 500 * .75);

        gc.drawImage(wbg, 0, 600 * .75);
        gc.drawImage(bbg, 100 * .75, 600 * .75);
        gc.drawImage(wbg, 200 * .75, 600 * .75);
        gc.drawImage(bbg, 300 * .75, 600 * .75);
        gc.drawImage(wbg, 400 * .75, 600 * .75);
        gc.drawImage(bbg, 500 * .75, 600 * .75);
        gc.drawImage(wbg, 600 * .75, 600 * .75);
        gc.drawImage(bbg, 700 * .75, 600 * .75);
        gc.drawImage(bbg, 0, 700 * .75);
        gc.drawImage(wbg, 100 * .75, 700 * .75);
        gc.drawImage(bbg, 200 * .75, 700 * .75);
        gc.drawImage(wbg, 300 * .75, 700 * .75);
        gc.drawImage(bbg, 400 * .75, 700 * .75);
        gc.drawImage(wbg, 500 * .75, 700 * .75);
        gc.drawImage(bbg, 600 * .75, 700 * .75);
        gc.drawImage(wbg, 700 * .75, 700 * .75);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    public void CreatePieces(){

        bbg = new Image("bbg.gif", 130 * .75, 130 * .75, true, false);
        bpawn  = new Image("bpawn.gif", 100 * .75, 100 * .75, true, false);
        brook  = new Image("brook.gif", 100 * .75, 100 * .75, true, false);
        bbishop  = new Image("bbishop.gif", 100 * .75, 100 * .75, true, false);
        bknight  = new Image("bknight.gif", 100 * .75, 100 * .75, true, false);
        bking  = new Image("bking.gif", 100 * .75, 100 * .75, true, false);
        bqueen = new Image("bqueen.gif", 100 * .75, 100 * .75, true, false);


        wbg = new Image("wbg.gif", 110 * .75, 110 * .75, true, false);
        wpawn  = new Image("wpawn.gif", 100 * .75, 100 * .75, true, false);
        wrook  = new Image("wrook.gif", 100 * .75, 100 * .75, true, false);
        wbishop  = new Image("wbishop.gif", 100 * .75, 100 * .75, true, false);
        wknight  = new Image("wknight.gif", 100 * .75, 100 * .75, true, false);
        wking  = new Image("wking.gif", 100 * .75, 100 * .75, true, false);
        wqueen = new Image("wqueen.gif", 100 * .75, 100 * .75, true, false);

    }


}
