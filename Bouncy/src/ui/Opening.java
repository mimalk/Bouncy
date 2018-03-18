package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Opening.
 */
public class Opening {
    //Background art resource: https://inspirationfeeed.files.wordpress.com/2014/11/dmzt71u1.png
    /**
     * Constant.
     */
    private static final int C20 = 20;
    /**
     * Constant.
     */
    private static final int C10 = 10;
    /**
     * Constant.
     */
    private static final int C30 = 30;
    /**
     * Constant.
     */
    private static final int C150 = 150;
    /**
     * Constant.
     */
    private static final int C50 = 50;
    /**
     * Constant.
     */
    private static final double C07 = 0.7;
    /**
     * Width.
     */
    private static final int WIDTH = 900;
    /**
     * Height.
     */
    private static final int HEIGHT = 700;
    /**
     * Stage.
     */
    private Stage stage;
    /**
     * The scene of the settings.
     */
    private Scene settingsScene;
    /**
     * The scene of instructions.
     */
    private Scene instructionsScene;
    /**
     * Class of the settings.
     */
    private Settings settingsClass;
    /**
     * Scene.
     */
    private Scene scene;
    /**
     * High score label.
     */
    private Label highscr;

    /**
     * Creates the opening scene.
     * @param primaryStage primaryStage.
     * @param soundtrack soundtrack.
     * @return Scene.
     */
    public Scene opening(Stage primaryStage, MediaPlayer soundtrack) {
        stage = primaryStage;
        ImageView heading = new ImageView(new Image("/design/BouncyHeading.png"));
        heading.setOpacity(C07);
        Button play = play();
        Button instructions = instructions();
        Button set = settings();
        Button exit = exit();
        //
        highscr = new Label("High score: " + readHighScore());
        highscr.setFont(Font.font("Serif", C30));
        highscr.setTextFill(Color.WHITE);
        highscr.setPadding(new Insets(C30));
        //
        VBox vBox = new VBox(heading, play, instructions, set, highscr);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(C30);
        vBox.setLayoutX(WIDTH / 2 - C150);
        vBox.setLayoutY(C50);
        //
        Pane pane = new Pane(vBox, exit);
        pane.setBackground(null);
        scene = new Scene(pane, WIDTH, HEIGHT);
        scene.setFill(new ImagePattern(new Image("/design/OpeningBackground.png")));
        settingsClass = new Settings();
        instructionsScene = new Instructions().instructions(this, settingsClass);
        settingsScene = settingsClass.settings(scene, this, stage, soundtrack);
        return scene;
    }

    /**
     * Gets the object of the Settings class.
     * @return Settings object.
     */
    public Settings getSettings() {
        return settingsClass;
    }

    /**
     * Makes the play button.
     * @return Play button.
     */
    public Button play() {
        Button play = new Button("Play");
        play.setFont(Font.font("Serif", C30));
        play.setShape(new Circle(C30));
        play.setCursor(Cursor.CLOSED_HAND);
        play.setOnAction(event -> {
            stage.setScene(new Game().playGame(this, stage));
        });
        return play;
    }

    /**
     * Gets the scene.
     * @return Scene.
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Reads the high score.
     * @return High score.
     */
    public String readHighScore() {
        String highScore = null;
        Path path = Paths.get("Bouncy", "src", "functionality", "HighScore");
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            highScore = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return highScore;
    }

    /**
     * Updates the high score.
     */
    public void updateHighScore() {
        highscr.setText("High score: " + readHighScore());
    }

    /**
     * Creates instructions button.
     * @return Button.
     */
    public Button instructions() {
        Button instructions = new Button("Instructions");
        instructions.setFont(Font.font("Serif", C30));
        instructions.setShape(new Circle(C30));
        instructions.setCursor(Cursor.HAND);
        instructions.setOnAction(event -> {
            stage.setScene(instructionsScene);
        });
        return instructions;
    }

    /**
     * Creates the settings button.
     * @return Button.
     */
    public Button settings() {
        Button set = new Button("Settings");
        set.setFont(Font.font("Serif", C30));
        set.setShape(new Circle(C30));
        set.setCursor(Cursor.HAND);
        set.setOnAction(event -> {
            stage.setScene(settingsScene);
        });
        return set;
    }

    /**
     * Creates the exit button.
     * @return Exit button.
     */
    public Button exit() {
        Button exit = new Button("X");
        exit.setFont(Font.font("Serif", C20));
        exit.setShape(new Circle(C20));
        exit.setCursor(Cursor.HAND);
        exit.setLayoutX(C10);
        exit.setLayoutY(C10);
        exit.setOnAction(event -> {
            stage.close();

        });
        return exit;
    }
}
