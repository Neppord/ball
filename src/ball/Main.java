package ball;

import com.sun.javafx.tk.Toolkit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    private World world = new World();
    private Handler handler = new Handler(world);
    private Display display = new Display(world);



    @Override
    public void start(Stage primaryStage) throws Exception{
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(1000 / 120), world::physics)
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();

        display.levelScene.setOnKeyPressed(handler::handleKeyPressed);
        display.levelScene.setOnKeyReleased(handler::handleKeyReleased);


        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Bounce");
        primaryStage.setScene(display.levelScene);
        primaryStage.show();

        Toolkit.getToolkit()
                .getMasterTimer()
                .addAnimationTimer(display::animate);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
