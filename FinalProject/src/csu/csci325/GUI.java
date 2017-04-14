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
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas(1600, 1600);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image r1c2 = new Image("DSC_7861.gif", 200, 200, true, false);

        Image r1c1 = new Image("DSC_7859.gif", 200, 200, true, false);
        Image sun = new Image("DSC_7863.gif", 200, 200, true, false);
        Image space = new Image("DSC_7864.gif", 200, 200, true, false);

        gc.drawImage(r1c1, 0, 0);
        gc.drawImage(r1c2, 200, 0);
        gc.drawImage(r1c1, 400, 0);
        gc.drawImage(r1c2, 600, 0);
        gc.drawImage(r1c1, 800, 0);
        gc.drawImage(r1c2, 1000, 0);
        gc.drawImage(sun, 0, 0);
        gc.drawImage(space, 600, 0);
        primaryStage.show();
    }
}
