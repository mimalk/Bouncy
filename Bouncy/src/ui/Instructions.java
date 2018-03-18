package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Instructions.
 */
public class Instructions {
    /**
     * Width.
     */
    private static final int WIDTH = 900;
    /**
     * Height.
     */
    private static final int HEIGHT = 700;
    /**
     * Constant.
     */
    private static final int C150 = 150;
    /**
     * Constant.
     */
    private static final int C130 = 130;
    /**
     * Constant.
     */
    private static final int C50 = 50;
    /**
     * Constant.
     */
    private static final int C10 = 10;
    /**
     * Constant.
     */
    private static final int C25 = 25;
    /**
     * Constant.
     */
    private static final int C210 = 210;
    /**
     * Constant.
     */
    private static final int C120 = 120;
    /**
     * Lines of the instruction's text.
     */
    private List<String> instructionLines = new ArrayList<>();

    /**
     * Makes the scene of instructions.
     * @param opening Opening object.
     * @param settings Settings object.
     * @return Scene.
     */
    public Scene instructions(Opening opening, Settings settings) {
        ImageView instructionsHeading = new ImageView(new Image("/design/Instructions.png"));
        instructionsHeading.setLayoutX(WIDTH / 2 - C150);
        instructionsHeading.setLayoutY(C10);
        ImageView names = new ImageView(new Image("/design/Names.png"));
        names.setLayoutX(WIDTH / 2 - C50);
        names.setLayoutY(HEIGHT - C130);
        Button exit = opening.exit();
        exit.setLayoutX(WIDTH - C50);
        exit.setLayoutY(C10);
        Pane pane = new Pane(settings.textBackground(), settings.back(), instructionsHeading, names, exit);
        pane.setBackground(null);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        scene.setFill(new ImagePattern(new Image("/design/OpeningBackground.png")));
        formInstructions(pane);
        return scene;
    }

    /**
     * Reads the instruction lines from the file.
     */
    public void readLines() {
        Path path = Paths.get("Bouncy", "src", "functionality", "Instructions");
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            while (true) {
                String newLine = reader.readLine();
                if (newLine != null) {
                    instructionLines.add(newLine);
                } else {
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the instructions.
     * @param pane pane.
     */
    public void formInstructions(Pane pane) {
        readLines();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        for (String line : instructionLines) {
            Label sentence = new Label(line);
            sentence.setFont(Font.font("Serif", C25));
            vbox.getChildren().add(sentence);
        }
        vbox.setLayoutX(C210);
        vbox.setLayoutY(C120);
        pane.getChildren().add(vbox);
    }
}
