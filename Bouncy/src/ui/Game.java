package ui;

import functionality.Boost;
import functionality.World;
import functionality.Ball;
import functionality.Brick;
import functionality.Level;
import functionality.Paddle;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Game class.
 */
public class Game {
    /**
     *Width.
     */
    private static final int WIDTH = 900;
    /**
     * Height.
     */
    private static final int HEIGHT = 700;
    /**
     * Game field height.
     */
    private static final int GAMEFIELDHEIGHT = 630;
    /**
     * Menu height.
     */
    private static final int MENUHEIGHT = 70;
    /**
     * A constant.
     */
    private static final double D135 = 1.35;
    /**
     * A constant.
     */
    private static final double D05 = 0.5;
    /**
     * A constant.
     */
    private static final double D02 = 0.2;
    /**
     * A constant.
     */
    private static final double D15 = 1.5;
    /**
     * A constant.
     */
    private static final double D09 = 0.9;
    /**
     * A constant.
     */
    private static final double D07 = 0.7;
    /**
     * A constant.
     */
    private static final int C3 = 3;
    /**
     * A constant.
     */
    private static final int C4 = 4;
    /**
     * A constant.
     */
    private static final int C10 = 10;
    /**
     * A constant.
     */
    private static final int C15 = 15;
    /**
     * A constant.
     */
    private static final int C20 = 20;
    /**
     * A constant.
     */
    private static final int C25 = 25;
    /**
     * A constant.
     */
    private static final int C30 = 30;
    /**
     * A constant.
     */
    private static final int C50 = 50;
    /**
     * A constant.
     */
    private static final int C60 = 60;
    /**
     * A constant.
     */
    private static final int C70 = 70;
    /**
     * A constant.
     */
    private static final int C90 = 90;
    /**
     * A constant.
     */
    private static final int C120 = 120;
    /**
     * A constant.
     */
    private static final int C250 = 250;
    /**
     * A constant.
     */
    private static final int C10000 = 10000;
    /**
     * Hash map of gamebricks.
     */
    private HashMap<Rectangle, Brick> gameBricks = new HashMap<>();
    /**
     * Borderpane.
     */
    private BorderPane borderPane;
    /***
     * Score label.
     */
    private Label score;
    /**
     * Current score points.
     */
    private int scorePoints = 0;
    /**
     * Level label.
     */
    private Label level;
    /**
     * Current level.
     */
    private Level currentLevel;
    /**
     * Lives label.
     */
    private Label lives;
    /**
     * Moving ball timeline.
     */
    private Timeline timeline;
    /**
     * Number of lives left.
     */
    private int livesLeft = C3;
    /**
     * Game ball.
     */
    private Circle gameBall;
    /**
     * Game paddle.
     */
    private Rectangle gamePaddle;
    /**
     * Functional paddle.
     */
    private Paddle paddle;
    /**
     * Functional ball.
     */
    private Ball ball;
    /**
     * Game field.
     */
    private Pane gameField;
    /**
     * World.
     */
    private World world;
    /**
     * Game field bounds.
     */
    private Bounds bounds;
    /**
     * Game opening.
     */
    private Opening opening;
    /**
     * Primary stage.
     */
    private Stage stage;
    /**
     * Ball's x direction.
     */
    private double directionX;
    /**
     * Ball's y direction.
     */
    private double directionY;
    /**
     * Pause before effect removal.
     */
    private PauseTransition pause = new PauseTransition();
    /**
     * All boosts (images).
     */
    private List<ImageView> boostImages = new ArrayList<>();

    /**
     * Starts the game.
     * @param op Opening class.
     * @param primaryStage Current stage.
     * @return Game scene.
     */
    public Scene playGame(Opening op, Stage primaryStage) {
        stage = primaryStage;
        opening = op;
        world = new World(opening.getSettings().getTheme());
        ball = world.getBall();
        paddle = world.getPaddle();
        createGameBall();
        createGamePaddle();
        gameField = new Pane(gameBall, gamePaddle);
        gameField.setPrefSize(WIDTH, GAMEFIELDHEIGHT);
        gameField.setCursor(Cursor.NONE);
        borderPane = new BorderPane();
        borderPane.setBackground(null);
        borderPane.setCenter(gameField);
        createLevel(1);
        createMenu();
        reset();
        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        scene.setFill(new ImagePattern(new Image(world.getBackground())));
        return scene;
    }

    /**
     * Sets the ball and the paddle back to the starting point.
     */
    public void reset() {
        moveGameBall();
        gamePaddle.setLayoutX(paddle.getStartX());
        gamePaddle.setLayoutY(paddle.getStartY());
        gameBall.setLayoutX(ball.getStartX());
        gameBall.setLayoutY(ball.getStartY());
        gamePaddle.layoutXProperty().bindBidirectional(gameBall.layoutXProperty());
        moveGamePaddle();
        gameField.setOnMouseClicked(event -> {
            timeline.play();
            gamePaddle.layoutXProperty().unbindBidirectional(gameBall.layoutXProperty());
        });
        directionX = ball.getDirectionX();
        directionY = ball.getDirectionY();
        for (ImageView boost : boostImages) {
            gameField.getChildren().remove(boost);
        }
    }

    /**
     * Creates game paddle.
     */
    public void createGamePaddle() {
        gamePaddle = new Rectangle(paddle.getWidth(), paddle.getHeight());
        Image paddleImage = new Image(paddle.getImageFile());
        gamePaddle.setFill(new ImagePattern(paddleImage));
    }

    /**
     * Creates game ball.
     */
    public void createGameBall() {
        gameBall = new Circle(ball.getRadius());
        Image ballImage = new Image(ball.getImageFile());
        gameBall.setFill(new ImagePattern(ballImage));
        gameBall.setOpacity(ball.getOpacity());
        directionX = ball.getDirectionX();
        directionY = ball.getDirectionY();
    }

    /**
     * Creates current level.
     * @param number Level number.
     */
    public void createLevel(int number) {
        if (number > C4) {
            timeline.stop();
            resetValues();
            new GameOverStage(scorePoints, stage, opening, gameField);
            gameField.getChildren().remove(gameBall);
        } else {
            currentLevel = new Level(number);
            int y = C30;
            for (String line : currentLevel.getRows()) {
                for (int x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '1') {
                        Brick brick = new Brick(x * C90, y, 1);
                        gameBricks.put(createBrick(brick), brick);
                    }
                    if (line.charAt(x) == '2') {
                        Brick brick = new Brick(x * C90, y, 2);
                        gameBricks.put(createBrick(brick), brick);
                    }
                }
                y += C30;
            }
        }
    }

    /**
     * Creates a brick.
     * @param brick Brick class.
     * @return A single brick.
     */
    public Rectangle createBrick(Brick brick) {
        Rectangle gameBrick = new Rectangle(brick.getWidth(), brick.getHeight());
        Image brickImage = new Image(brick.getImage());
        gameBrick.setFill(new ImagePattern(brickImage));
        gameBrick.setOpacity(D09);
        gameBrick.setLayoutX(brick.getX());
        gameBrick.setLayoutY(brick.getY());
        gameField.getChildren().add(gameBrick);
        return gameBrick;
    }

    //Got a hint from: https://www.mkyong.com/javafx/javafx-animated-ball-example/ - code by Marilena Panagiotidou.
    /**
     * Move the game ball.
     */
    public void moveGameBall() {
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(ball.getSpeed()), event -> {
            if (gameField.getChildren().contains(gameBall)) {
                gameBall.setLayoutX(gameBall.getLayoutX() + directionX);
                gameBall.setLayoutY(gameBall.getLayoutY() + directionY);
                bounds = borderPane.getCenter().getBoundsInLocal();
                if (gameBall.getLayoutX() <= gameBall.getRadius() + 2
                        || gameBall.getLayoutX() >= (bounds.getMaxX() - gameBall.getRadius() - 2)) {
                    directionX = -1 * directionX;
                }
                if (gameBall.getLayoutY() <= gameBall.getRadius() + 2) {
                    directionY = -1 * directionY;
                }
                if (gamePaddle.getBoundsInParent().intersects(gameBall.getBoundsInParent())) {
                    guideBall();
                    directionY = -1 * directionY;
                }
                brickCollision();
                ballFall();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    /**
     * Lets the player guide the ball.
     */
    public void guideBall() {
        if (gameBall.getLayoutX() <= gamePaddle.getLayoutX() + C25) {
            directionX = -1;
            directionY = 1;
        } else if (gameBall.getLayoutX() >= gamePaddle.getLayoutX() + gamePaddle.getWidth() - C25) {
            directionX = 1;
            directionY = 1;
        } else if (gameBall.getLayoutX() >= gamePaddle.getLayoutX() + C25
            && gameBall.getLayoutX() <= gamePaddle.getLayoutX() + C60) {
            directionX = -D05;
            directionY = (directionY == 1) ? D135 * directionY : directionY;
        } else if (gameBall.getLayoutX() >= gamePaddle.getLayoutX() + gamePaddle.getWidth() - C60
                    && gameBall.getLayoutX() <= gamePaddle.getLayoutX() + gamePaddle.getWidth() - C25) {
            directionX = D05;
            directionY = (directionY == 1) ? D135 * directionY : directionY;
        } else if (gameBall.getLayoutX() >= gamePaddle.getLayoutX() + C60
                && gameBall.getLayoutX() <= gamePaddle.getLayoutX() + gamePaddle.getWidth() - C60) {
            directionX = (directionX > 0) ? D02 : -D02;
            directionY = D15;
        }
    }

    /**
     * Defines ball movement after intersecting with a brick.
     */
    public void brickCollision() {
        int numberOfBricksHit = 0;
        for (Rectangle brick : gameBricks.keySet()) {
            if (gameBall.getBoundsInParent().intersects(brick.getBoundsInParent())) {
                numberOfBricksHit++;
                Brick currentBrick = gameBricks.get(brick);
                Bounds brickBounds = brick.getBoundsInParent();
                if ((brickBounds.getMaxY() - 2 <= gameBall.getBoundsInParent().getMinY()
                        && brickBounds.getMaxY() >= gameBall.getBoundsInParent().getMinY())
                        || (brickBounds.getMinY() + 2 >= gameBall.getBoundsInParent().getMaxY())
                        && brickBounds.getMinY() <= gameBall.getBoundsInParent().getMaxY()) {
                    directionY = (numberOfBricksHit == 2) ? directionY : -1 * directionY;
                } else {
                    directionX = (numberOfBricksHit == 2) ? directionX : -1 * directionX;
                }
                currentBrick.damageBrick();
                scoreAdd(C10);
                if (currentBrick.isBroken()) {
                    gameField.getChildren().remove(brick);
                    gameBricks.remove(brick);
                    Sounds.playPoppingSound();
                    nextLevel(brick);
                    break;
                } else {
                    Image brokenBrickImage = new Image(currentBrick.getBrokenImage());
                    brick.setFill(new ImagePattern(brokenBrickImage));
                }
            }
        }
    }

    /**
     * Defines what happens after the ball falling down.
     */
    public void ballFall() {
        if (gameBall.getLayoutY() >= (bounds.getMaxY() - gameBall.getRadius())) {
            livesLeft--;
            lives.setText("Lives: " + livesLeft);
            timeline.stop();
            if (livesLeft == 0) {
                resetValues();
                new GameOverStage(scorePoints, stage, opening, gameField);
                gameField.getChildren().remove(gameBall);
            } else {
                resetValues();
                reset();
            }
        }
    }

    /**
     * Generates either a good or bad boost (image).
     * @param brokenBrick Brick that was broken and drops the boost.
     */
    public void randomBoost(Rectangle brokenBrick) {
        Boost boost;
        ImageView boostImage;
        Random random = new Random();
        int boostDrops = random.nextInt(C3);
        if (boostDrops == 0) {
            boost = new Boost("Good");
            boostImage = new ImageView(new Image(boost.getImage()));
            dropBoost(boost, boostImage, brokenBrick);
            boostImages.add(boostImage);
        }
        if (boostDrops == 1) {
            boost = new Boost("Bad");
            boostImage = new ImageView(new Image(boost.getImage()));
            dropBoost(boost, boostImage, brokenBrick);
            boostImages.add(boostImage);
        }
    }

    /**
     * Movement of the boost.
     * @param boost Boost.
     * @param boostImage Boost's image.
     * @param brokenBrick Brick that was broken.
     */
    public void dropBoost(Boost boost, ImageView boostImage, Rectangle brokenBrick) {
        boostImage.setFitHeight(C30);
        boostImage.setFitWidth(C30);
        boostImage.setLayoutX(brokenBrick.getLayoutX());
        boostImage.setLayoutY(brokenBrick.getLayoutY());
        gameField.getChildren().add(boostImage);
        Timeline boostTimeline = new Timeline();
        boostTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(C3), event -> {
            boostImage.setLayoutY(boostImage.getLayoutY() + 1);
            if (boostImage.getBoundsInParent().intersects(gamePaddle.getBoundsInParent())) {
                gameField.getChildren().remove(boostImage);
                resetValues();
                String characteristic = boost.getCharacteristic();
                int points = (characteristic.equals("Good")) ? C20 : -C10;
                if (characteristic.equals("Good")) {
                    goodBoosts();
                } else {
                    badBoosts();
                }
                scoreAdd(points);
                boostTimeline.stop();
            }
        }));
        Double d = brokenBrick.getLayoutY();
        Integer x = d.intValue();
        boostTimeline.setCycleCount(HEIGHT - x);
        boostTimeline.play();
        boostTimeline.setOnFinished(event -> {
            gameField.getChildren().remove(boostImage);
        });
    }

    /**
     * Resets default values.
     */
    public void resetValues() {
        pause.stop();
        gamePaddle.setVisible(true);
        gamePaddle.setWidth(paddle.getWidth());
        shiftBall(ball.getRadius());
        gameBall.setRadius(ball.getRadius());
    }

    /**
     * Shifts the ball.
     * @param radius Ball radius.
     */
    public void shiftBall(int radius) {
        if (gameBall.getLayoutX() + radius > WIDTH) {
            gameBall.setLayoutX(WIDTH - radius);
        } else if (gameBall.getLayoutX() - radius < 0) {
            gameBall.setLayoutX(radius);
        } else if (gameBall.getLayoutY() - radius < 0) {
            gameBall.setLayoutY(radius);
        } else if (gameBall.getLayoutY() + radius > gamePaddle.getLayoutY()) {
            gameBall.setLayoutY(gamePaddle.getLayoutY() - radius);
        }
    }

    /**
     * Resets pause.
     */
    public void resetPause() {
        pause.stop();
        pause = new PauseTransition(Duration.millis(C10000));
        pause.setOnFinished(event -> {
            resetValues();
        });
        pause.play();
    }

    /**
     * Defines good boosts.
     */
    public void goodBoosts() {
        resetPause();
        Random random = new Random();
        int rand = random.nextInt(1);
        if (rand == 1) {
            livesLeft++;
            lives.setText("Lives: " + livesLeft);
        } else if (rand == 2) {
            if (gamePaddle.getLayoutX() + C250 > WIDTH) {
                gamePaddle.setLayoutX(WIDTH - C250);
            }
            gamePaddle.setWidth(C250);
        } else if (rand == 0) {
            shiftBall(C25);
            gameBall.setRadius(C25);
        }

    }

    /**
     * Defines bad boosts.
     */
    public void badBoosts() {
        resetPause();
        Random random = new Random();
        int rand = random.nextInt(C4);
        if (rand == 0) {
            livesLeft--;
            lives.setText("Lives: " + livesLeft);
            if (livesLeft == 0) {
                resetValues();
                new GameOverStage(scorePoints, stage, opening, gameField);
                gameField.getChildren().remove(gameBall);
            }
        } else if (rand == 1) {
            gamePaddle.setWidth(C70);
        } else if (rand == 2) {
            gameBall.setRadius(C10);
        } else if (rand == C3) {
            gamePaddle.setVisible(false);
        }
    }

    /**
     * Moves game paddle.
     */
    public void moveGamePaddle() {
        gameField.setOnMouseMoved(event -> {
            double mouseX = event.getX();
            if (mouseX + gamePaddle.getWidth() <= gameField.getWidth()) {
                gamePaddle.setLayoutX(mouseX);
            }
        });
    }

    /**
     * Adds points to the score.
     * @param points Points that will be added.
     */
    public void scoreAdd(int points) {
        scorePoints += points;
        score.setText("Points: " + scorePoints);
    }

    /**
     * Creates the upper menu.
     */
    public void createMenu() {
        score = new Label("Points: " + scorePoints);
        score.setFont(Font.font("Serif", C30));
        score.setTextFill(Color.valueOf("#853392"));
        score.setLayoutX(C70);
        score.setLayoutY(C15);
        level = new Label("Level: " + currentLevel.getCurrentLevel());
        level.setFont(Font.font("Serif", C30));
        level.setTextFill(Color.valueOf("#853392"));
        level.setLayoutX(WIDTH / 2 - C50);
        level.setLayoutY(C15);
        lives = new Label("Lives: " + livesLeft);
        lives.setFont(Font.font("Serif", C30));
        lives.setTextFill(Color.valueOf("#853392"));
        lives.setLayoutX(WIDTH - C120);
        lives.setLayoutY(C15);
        Button exit = opening.exit();
        exit.setLayoutX(C10);
        exit.setLayoutY(C10);
        Pane menu = new Pane(exit, score, level, lives);
        menu.setStyle("-fx-background-color: #dcdcdc");
        menu.setOpacity(D07);
        menu.setPrefSize(WIDTH, MENUHEIGHT);
        borderPane.setTop(menu);
    }

    /**
     * Checks whether the level is empty or not.
     * @return True (empty) or false (not empty).
     */
    public boolean checkEmptyLevel() {
        return gameBricks.isEmpty();
    }

    /**
     * Check whether the game is ready for the next level. If it is, then runs required methods to create next level.
     * @param brick Last brick that was broken.
     */
    public void nextLevel(Rectangle brick) {
        if (checkEmptyLevel()) {
            resetValues();
            createLevel(currentLevel.getCurrentLevel() + 1);
            livesLeft = C3;
            lives.setText("Lives: " + livesLeft);
            level.setText("Level: " + currentLevel.getCurrentLevel());
            timeline.stop();
            timeline.getKeyFrames().clear();
            reset();
        } else if (!checkEmptyLevel()) {
            randomBoost(brick);
        }
    }
}
