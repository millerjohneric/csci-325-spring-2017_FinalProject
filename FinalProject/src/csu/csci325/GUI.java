package csu.csci325;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    public String strStatus="";
    boolean turn;

    static String origin="";
    static String destination="";

    ChessBoard gameBoard;
    public void start(Stage primaryStage) throws Exception {
        turn = true;
        root = new Group();
        theScene = new Scene(root);
        primaryStage.setScene(theScene);
        Button bMove = new Button("Move");
        Button bClear = new Button("Clear");
        Label lOrigin = new Label("Origin: ");
        Label lDestination = new Label("Destination: ");
        Label lOriginV = new Label("");
        Label lDestinationV = new Label("");
        Label lStatus = new Label("Click the piece you want to move.");
        Label lColor = new Label("Orange players turn.");
        canvas = new Canvas(1400, 700);
        root.getChildren().add(canvas);
        HBox menu = new HBox(5);
        menu.setPadding(new Insets(10));
        menu.setAlignment(Pos.BASELINE_RIGHT);
        menu.setLayoutX(650);
        menu.setLayoutY(000);
        menu.getChildren().addAll(lOrigin, lOriginV, lDestination, lDestinationV,bMove,bClear,lStatus);

        HBox mTurn = new HBox(5);
        mTurn.setPadding(new Insets(10));
        mTurn.setAlignment(Pos.BASELINE_RIGHT);
        mTurn.setLayoutX(650);
        mTurn.setLayoutY(50);
        mTurn.getChildren().add(lColor);
        root.getChildren().addAll(menu,mTurn);
        //root.getChildren().add(button);
        gc = canvas.getGraphicsContext2D();
        bClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                lOriginV.setText("");
                lDestinationV.setText("");
                origin="";
                destination="";

                lStatus.setText("Click the piece you want to move.");
            }
        });
        bMove.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                if (gameBoard.MovePiece(lOriginV.getText(),  lDestinationV.getText())== -1){
                lStatus.setText("You cannot move here you already have a piece on that tile.");
                }else{
                    RefreshBoard();
                    gameBoard.Display();
                    lStatus.setText(strStatus);
                    if (lColor.getText().equals("Orange players turn.")){

                        lColor.setText("Blue players turn.");
                    }else{

                        lColor.setText("Orange players turn.");
                    }

                }
                //lStatus.setText("Click the piece you want to move.");
                lOriginV.setText("");
                lDestinationV.setText("");
                origin="";
                destination="";

            }
        });
        theScene.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //System.out.println("Mouse clicked on " + event.getX() + ", " + event.getY());
                //System.out.println(AlphaFromX(event.getX()));
                //System.out.println(Integer.toString(RowFromY(event.getY())));
                //System.out.println("");

                if (origin.equals("")){
                    // set the origin
                    origin = AlphaFromX(event.getX()) + Integer.toString(RowFromY(event.getY()));
                    lOriginV.setText(origin);

                    lStatus.setText("Now click your destination.");
                    //System.out.println( origin);
                }else if (destination.equals("")){
                    // set destination

                    destination = AlphaFromX(event.getX()) + Integer.toString(RowFromY(event.getY()));
                    lDestinationV.setText(destination);
                    //System.out.println( destination);


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
    public static void main(String[] args) {
        Application.launch(args);
    }


}
