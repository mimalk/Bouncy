package ui;

import javafx.application.Application;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * User interface class.
 */
public class UserInterface extends Application {
    /**
     * Game soundtrack.
     */
    private MediaPlayer soundtrack;

    /**
     * Main.
     * @param args arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        soundtrack = Sounds.getSoundtrack();
        soundtrack.play();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Bouncy");
        primaryStage.setScene(new Opening().opening(primaryStage, soundtrack));
        primaryStage.show();
    }
}
