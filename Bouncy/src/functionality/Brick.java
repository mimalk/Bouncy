package functionality;

/**
 * Brick class.
 */
public class Brick {
    //Brick crack art: http://www.editarena.com/picsart-crack-png-photo-editing/
    /**
     * Width of the brick.
     */
    public static final int WIDTH = 90;
    /**
     * Height of the brick.
     */
    public static final int HEIGHT = 30;
    /**
     * Broken.
     */
    private boolean broken;
    /**
     * Width.
     */
    private int width;
    /**
     * Height.
     */
    private int height;
    /**
     * Strength.
     */
    private int strength;
    /**
     * Image of the brick.
     */
    private String image;
    /**
     * Image of a broken brick.
     */
    private String brokenImage;
    /**
     * x coordinate.
     */
    private int x;
    /**
     * y coordinate.
     */
    private int y;

    /**
     * Constructor.
     * @param x x coordinate.
     * @param y y coordinate.
     * @param strength strength.
     */
    public Brick(int x, int y, int strength) {
        this.broken = false;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.image = "/design/PurpleBrick.png";
        this.brokenImage = "/design/PurpleBrickCracked.png";
        this.strength = strength;
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the image of the brick.
     * @return image.
     */
    public String getImage() {
        return image;
    }

    /**
     * Gets the broken image.
     * @return broken image.
     */
    public String getBrokenImage() {
        return brokenImage;
    }

    /**
     * Gets the width.
     * @return width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height.
     * @return height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the x.
     * @return x.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y.
     * @return y.
     */
    public int getY() {
        return y;
    }

    /**
     * Breaks a brick.
     */
    public void breakBrick() {
        broken = true;
    }

    /**
     * Damages a brick.
     */
    public void damageBrick() {
        strength--;
        if (strength == 0) {
            breakBrick();
        }
    }

    /**
     * Returns true, if the brick is broken and false otherwise.
     * @return true or false.
     */
    public boolean isBroken() {
        return broken;
    }
}
