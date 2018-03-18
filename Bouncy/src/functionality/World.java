package functionality;

/**
 * World class.
 */
public class World {
    //Art credits:
    //default ball art - http://opengameart.org/content/purple-circle
    //bubble ball art - http://opengameart.org/content/ball-animation-include-vector-file
    //brick & paddle art - http://opengameart.org/content/puzzle-game-art
    //water world background art - http://www.deviantart.com/art/Underwater-Ruins-265381885 (by: artofjokinen)
    //forest world background art - http://syarul.deviantart.com/art/gateway-163679514 (by: syarul)
    /**
     * Ball start x.
     */
    public static final int BALLSTARTX = 75;
    /**
     * Ball start y.
     */
    public static final int BALLSTARTY = 575;
    /**
     * Ball radius.
     */
    public static final int RADIUS = 15;
    /**
     * Ball speed.
     */
    public static final int SPEED = 4;
    /**
     * Paddle start y.
     */
    public static final int PADDLESTARTY = 600;
    /**
     * Paddle height.
     */
    public static final int PADDLEHEIGHT = 20;
    /**
     * Paddle width.
     */
    public static final int PADDLEWIDTH = 150;
    /**
     * Ball's opacity.
     */
    public static final double OPACITY = 0.7;
    /**
     * Name represents the game's setting. (Default/water/heaven)
     */
    private String name;
    /**
     * Ball object.
     */
    private Ball ball;
    /**
     * Paddle object.
     */
    private Paddle paddle;
    /**
     * Background image.
     */
    private String background;

    /**
     * Constructor.
     * @param name name of the world.
     */
    public World(String name) {
        this.name = name;
        generateDesign();
    }

    /**
     * Generates the design for the certain world.
     */
    public void generateDesign() {
        this.ball = new Ball(BALLSTARTX, BALLSTARTY, -1, -1);
        ball.setRadius(RADIUS);
        ball.setSpeed(SPEED);
        this.paddle = new Paddle(0, PADDLESTARTY, PADDLEHEIGHT);
        paddle.setWidth(PADDLEWIDTH);
        if (name.equals("Forest")) {
            ball.setImageFile("DefaultBall.png");
            ball.setOpacity(1.0);
            paddle.setImageFile("DefaultPaddle.png");
            this.background = "/design/ForestBackground.png";
        } else if (name.equals("Water")) {
            ball.setImageFile("BubbleBall.png");
            ball.setOpacity(OPACITY);
            paddle.setImageFile("WaterPaddle.png");
            this.background = "/design/WaterBackground.png";
        }
    }

    /**
     * Gets the ball.
     * @return ball object.
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * Gets the paddle object.
     * @return paddle object.
     */
    public Paddle getPaddle() {
        return paddle;
    }

    /**
     * Gets the background.
     * @return background.
     */
    public String getBackground() {
        return background;
    }
}
