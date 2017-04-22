package csu.csci325;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

/**
 * Created by Lalal on 4/21/2017.
 */
public class ChessView extends Application {

    public ChessView (){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button newButton = new Button("New");
        //Button quitButton = new Button("Quit");

        Scene scene = new Scene(newButton, 200, 500);

        newButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                stage.setTitle("Welcome to the Chess World!");
                ImageView chessBoard = new ImageView("chessboard.png");

                Pane pane = new Pane();
                pane.getChildren().add(chessBoard);

                Scene scene = new Scene(pane, chessBoard.getImage().getWidth(), chessBoard.getImage().getHeight());

                stage.setScene(scene);
                stage.show();

            }


        });

        primaryStage.setTitle("Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void show() {

    }

    public void createGUI (){

    }

    public static void main (String[] args){
        Application.launch(args);
    }
}

