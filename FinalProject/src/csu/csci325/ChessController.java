package csu.csci325;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.event.MouseEvent;

/**
 * Created by Lalal on 4/21/2017.
 */
public class ChessController implements EventHandler<ActionEvent> {

    public static ChessBoard chessBoard;
    private static ChessController chessController;
    private ChessModel chessModel;
    private ChessView chessView;
    public static ChessController getChessController(){

        if (chessController == null){
            chessController = new ChessController();
        }

        return chessController;
    }

    public ChessController(){

        chessBoard = new ChessBoard();
        chessModel = new ChessModel();
        chessView = new ChessView();

    }

    public void show() {
        //show GUI
        this.chessView.show();
    }

    public void setChessView (ChessView view){
        chessView = view;
    }


    @Override
    public void handle(ActionEvent event) {

    }

    public static void main (String[] args){
        Application.launch(args);
    }
}
