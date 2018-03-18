package functionality;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests.
 */
public class Tests {
    /**
     * Creates an instance variable of the ball.
     */
    private Ball ball;
    /**
     * Creates an instance variable of the paddle.
     */
    private Paddle paddle;
    /**
     * Creates an instance variable of the brick.
     */
    private Brick brick;
    /**
     * Creates an instance variable of the world.
     */
    private World world;
    /**
     * A constant.
     */
    private static final int C5 = 5;
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
    private static final int C30 = 30;
    /**
     * A constant.
     */
    private static final int C40 = 40;
    /**
     * A constant.
     */
    private static final int C50 = 50;
    /**
     * A constant.
     */
    private static final int C150 = 150;
    /**
     * A constant.
     */
    private static final double D02 = 0.2;
    /**
     * A constant.
     */
    private static final double D0001 = 0.001;
    /**
     * A constant.
     */
    private static final double D07 = 0.7;
    /**
     * Creates an instance.
     * @throws Exception m.
     */
    @Before
    public void setUp() throws Exception {
        this.ball = new Ball(0, C20, 1, 1);
        this.paddle = new Paddle(C50, C50, C30);
        this.brick = new Brick(C30, C40, 2);
        this.world = new World("Water");
    }
    /**
     * Test setting and getting the image file.
     */
    @Test
    public void getBallImageFile() {
        ball.setImageFile("ball.png");
        assertEquals("/design/ball.png", ball.getImageFile());
    }
    /**
     * Test setting and getting the ball radius.
     */
    @Test
    public void getBallRadius() {
        ball.setRadius(C20);
        ball.setRadius(C15);
        assertEquals(C15, ball.getRadius());
    }
    /**
     * Test setting and getting the ball opacity.
     */
    @Test
    public void getBallOpacity() {
        ball.setOpacity(D02);
        assertEquals(D02, ball.getOpacity(), D0001);
    }
    /**
     * Test setting and getting the ball speed.
     */
    @Test
    public void getBallSpeed() {
        ball.setSpeed(C5);
        assertEquals(C5, ball.getSpeed());
    }
    /**
     * Test setting and getting the paddle width.
     */
    @Test
    public void getPaddleWidth() {
        paddle.setWidth(C150);
        assertEquals(C150, paddle.getWidth());
    }
    /**
     * Test setting and getting the paddle image file.
     */
    @Test
    public void getPaddleImageFile() {
        paddle.setImageFile("Paddle.png");
        assertEquals("/design/Paddle.png", paddle.getImageFile());
    }
    /**
     * Test breaking brick with strength 2 once.
     */
    @Test
    public void testBrickStrenght() {
        brick.damageBrick();
        assertFalse(brick.isBroken());
    }
    /**
     * Test breaking brick with strength 2 twice.
     */
    @Test
    public void testBrickStrenght2() {
        brick.damageBrick();
        brick.damageBrick();
        assertTrue(brick.isBroken());
    }
    /**
     * Test setting and getting the good boost image.
     */
    @Test
    public void testGoodBoostImage() {
        Boost goodBoost = new Boost("Good");
        assertEquals("/design/GoodBoost.png", goodBoost.getImage());
    }
    /**
     * Test setting and getting the bad boost image.
     */
    @Test
    public void testBadBoostImage() {
        Boost badBoost = new Boost("Bad");
        assertEquals("/design/BadBoost.png", badBoost.getImage());
    }
    /**
     * Test making a world.
     */
    @Test
    public void testWorld() {
        assertEquals(D07, world.getBall().getOpacity(), D0001);
        assertEquals("/design/WaterPaddle.png", world.getPaddle().getImageFile());
        assertEquals("/design/WaterBackground.png", world.getBackground());
        assertEquals("/design/BubbleBall.png", world.getBall().getImageFile());
    }
}
