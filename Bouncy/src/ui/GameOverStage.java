package ui;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Game over stage.
 */
public class GameOverStage {
    /**
     * Stage width.
     */
    public static final int WIDTH = 300;
    /**
     * Stage height.
     */
    public static final int HEIGHT = 200;
    /**
     * The player's score.
     */
    private int score;
    /**
     * Writer.
     */
    private BufferedWriter writer;
    /**
     * Path to high score file.
     */
    private Path path;
    /**
     * A constant.
     */
    private static final int C20 = 20;
    /**
     * A constant.
     */
    private static final int C30 = 30;
    /**
     * A constant.
     */
    private static final int C60 = 60;
    /**
     * A constant.
     */
    private static final int C50 = 50;
    /**
     * A constant.
     */
    private static final int C70 = 70;

    /**
     * Creates new stage in case the game is over.
     * @param points The player's final score.
     * @param primaryStage Game stage.
     * @param opening Game's opening.
     * @param gameField Game field.
     */
    public GameOverStage(int points, Stage primaryStage, Opening opening, Pane gameField) {
        path = Paths.get("Bouncy", "src", "functionality", "HighScore");
        score = points;
        gameField.setCursor(Cursor.DEFAULT);
        Stage gameOver = new Stage();
        Label yourScore = new Label("Your score: " + score);
        yourScore.setFont(Font.font("Serif", C30));
        yourScore.setLayoutX(C20);
        yourScore.setLayoutY(C20);
        Button ok = new Button("OK");
        ok.setFont(Font.font("Serif", C20));
        ok.setShape(new Circle(C20));
        ok.setCursor(Cursor.HAND);
        ok.setLayoutX(WIDTH - C70);
        ok.setLayoutY(HEIGHT - C50);
        ok.setOnAction(event -> {
            gameOver.close();
            opening.updateHighScore();
            primaryStage.setScene(opening.getScene());
        });
        Label hs = new Label("High score: " + getHighScore());
        hs.setFont(Font.font("Serif", C30));
        hs.setLayoutX(C20);
        hs.setLayoutY(C60);

        Pane pane = new Pane(yourScore, ok, hs);
        pane.setStyle("-fx-background-color: aquamarine");
        gameOver.initStyle(StageStyle.UNDECORATED);
        gameOver.setScene(new Scene(pane, WIDTH, HEIGHT));
        gameOver.show();
    }

    /**
     * Returns highest score.
     * @return High score.
     */
    public int getHighScore() {
        int highScore = 0;
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            highScore = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (highScore < score) {
            highScore = score;
            overWriteHighScore(highScore);
        }
        return highScore;
    }

    /**
     * Overwrites high score.
     * @param highScore High score.
     */
    public void overWriteHighScore(int highScore) {
        try {
            writer = Files.newBufferedWriter(path);
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
