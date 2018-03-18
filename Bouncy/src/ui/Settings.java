package ui;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Settings.
 */
public class Settings {
    //Background art resource: https://inspirationfeeed.files.wordpress.com/2014/11/dmzt71u1.png
    //Speaker art resource: http://septicscompanion.com/wp-content/themes/septics/images/speaker.png
    /**
     * Constant.
     */
    private static final int C80 = 80;
    /**
     * Constant.
     */
    private static final int C30 = 30;
    /**
     * Constant.
     */
    private static final int C10 = 10;
    /**
     * Constant.
     */
    private static final int C50 = 50;
    /**
     * Constant.
     */
    private static final int C120 = 120;
    /**
     * Constant.
     */
    private static final int C300 = 300;
    /**
     * Constant.
     */
    private static final int C60 = 60;
    /**
     * Constant.
     */
    private static final int C100 = 100;
    /**
     * Constant.
     */
    private static final int C200 = 200;
    /**
     * Constant.
     */
    private static final int C130 = 130;
    /**
     * Constant.
     */
    private static final int C360 = 360;
    /**
     * Constant.
     */
    private static final double C07 = 0.7;
    /**
     * Constant.
     */
    private static final int C400 = 400;
    /**
     * Constant.
     */
    private static final int C180 = 180;
    /**
     * Constant.
     */
    private static final int C3 = 3;
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
    private Stage primaryStage;
    /**
     * Opening scene.
     */
    private Scene opening;
    /**
     * Opening object.
     */
    private Opening open;
    /**
     * Forest button.
     */
    private Button forest = new Button("Forest");
    /**
     * Water button.
     */
    private Button water = new Button("Water");
    /**
     * Speaker's image.
     */
    private Image speakerImage = new Image("/design/Speaker.png");
    /**
     * Speaker's no sound image.
     */
    private Image speakerNoSoundImage = new Image("/design/SpeakerNoSound.png");
    /**
     * Imageview of the speaker.
     */
    private ImageView speaker = new ImageView(speakerImage);
    /**
     * Image of the forest world.
     */
    private Image forestPreview = new Image("/design/ForestPreview.png");
    /**
     * Image of the water world.
     */
    private Image waterPreview = new Image("/design/WaterPreview.png");
    /**
     * Image view of the forest image.
     */
    private ImageView previewImage = new ImageView(forestPreview);
    /**
     * Sound of the game.
     */
    private MediaPlayer sound;

    /**
     * Creates the settings scene.
     * @param openingScene Opening scene.
     * @param openingClass Opening object.
     * @param stage Stage.
     * @param soundtrack Soundtrack.
     * @return Scene.
     */
    public Scene settings(Scene openingScene, Opening openingClass, Stage stage, MediaPlayer soundtrack) {
        opening = openingScene;
        primaryStage = stage;
        open = openingClass;
        sound = soundtrack;
        Button exit = open.exit();
        exit.setLayoutX(WIDTH - C50);
        exit.setLayoutY(C10);
        ImageView settingsHeading = new ImageView(new Image("/design/Settings.png"));
        settingsHeading.setLayoutX(WIDTH / 2 - C100);
        settingsHeading.setLayoutY(C10);
        Label pickTheme = new Label("Game theme:");
        pickTheme.setFont(Font.font("Serif", C30));
        pickTheme.setLayoutX(WIDTH / 2 - C80);
        pickTheme.setLayoutY(C120);
        Label preview = new Label("Preview:");
        preview.setFont(Font.font("Serif", C30));
        preview.setLayoutX(WIDTH / 2 - C60);
        preview.setLayoutY(C300);
        definePreviewImage();
        Pane pane = new Pane(textBackground(), exit, settingsHeading, back(),
                themes(), pickTheme, speaker, preview, previewImage);
        pane.setBackground(null);
        soundToggle();
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        scene.setFill(new ImagePattern(new Image("/design/OpeningBackground.png")));
        return scene;
    }

    /**
     * Define's the preview image.
     */
    public void definePreviewImage() {
        previewImage.setLayoutX(WIDTH / 2 - C130);
        previewImage.setLayoutY(C360);
        previewImage.setOpacity(C07);
        previewImage.setOnMouseEntered(event -> {
            previewImage.setOpacity(1.0);
        });
        previewImage.setOnMouseExited(event -> {
            previewImage.setOpacity(C07);
        });
    }

    /**
     * Creates the back button.
     * @return Button.
     */
    public Button back() {
        Button back = new Button("Back");
        back.setFont(Font.font("Serif", C30));
        back.setShape(new Circle(C30));
        back.setCursor(Cursor.HAND);
        back.setOnAction(event -> {
            primaryStage.setScene(opening);
        });
        back.setLayoutX(C10);
        back.setLayoutY(C10);
        return back;
    }

    /**
     * Creates the text background.
     * @return rectangle.
     */
    public Rectangle textBackground() {
        Rectangle bg = new Rectangle(WIDTH - C400, HEIGHT);
        bg.setFill(Color.WHITE);
        bg.setOpacity(C07);
        bg.setLayoutX(C200);
        return bg;
    }

    /**
     * Creates the theme buttons.
     * @return HBox.
     */
    public HBox themes() {
        designButton(forest);
        forest.setStyle("-fx-background-color: aquamarine");
        forest.setOnAction(event -> {
            forest.setStyle("-fx-background-color: aquamarine");
            previewImage.setImage(forestPreview);
            water.setStyle(null);
        });
        designButton(water);
        water.setOnAction(event -> {
            water.setStyle("-fx-background-color: aquamarine");
            previewImage.setImage(waterPreview);
            forest.setStyle(null);
        });
        HBox hBox = new HBox(forest, water);
        hBox.setSpacing(C50);
        hBox.setLayoutX(WIDTH / C3 + C10);
        hBox.setLayoutY(C180);
        return hBox;
    }

    /**
     * Gets the theme.
     * @return Theme string.
     */
    public String getTheme() {
        if (forest.getStyle().equals("-fx-background-color: aquamarine")) {
            return "Forest";
        } else {
            return "Water";
        }
    }

    /**
     * Designs the buttons.
     * @param button Button.
     */
    public void designButton(Button button) {
        button.setFont(Font.font("Serif", C30));
        button.setShape(new Circle(C30));
        button.setCursor(Cursor.HAND);
    }

    /**
     * Creates the speaker image and puts it on action.
     */
    public void soundToggle() {
        speaker.setFitWidth(C80);
        speaker.setFitHeight(C80);
        speaker.setLayoutX(WIDTH / C3 - C80);
        speaker.setLayoutY(HEIGHT - C100);
        speaker.setOnMousePressed(event -> {
            if (speaker.getImage().equals(speakerImage)) {
                speaker.setImage(speakerNoSoundImage);
                sound.stop();
            } else {
                speaker.setImage(speakerImage);
                sound.play();
            }
        });
    }
}
