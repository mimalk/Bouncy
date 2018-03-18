package functionality;

/**
 * Ball.
 */
public class Ball {
    /**
     * Start x.
     */
    private int startX;
    /**
     * Start y.
     */
    private int startY;
    /**
     * x direction.
     */
    private int directionX;
    /**
     * y direction.
     */
    private int directionY;
    /**
     * Radius.
     */
    private int radius;
    /**
     * Opacity.
     */
    private double opacity;
    /**
     * Image.
     */
    private String image;
    /**
     * Speed.
     */
    private int speed;

    /**
     * Constructor.
     * @param startX start x.
     * @param startY start y.
     * @param directionX direction x.
     * @param directionY direction y.
     */
    public Ball(int startX, int startY, int directionX, int directionY) {
        this.startX = startX;
        this.startY = startY;
        this.directionX = directionX;
        this.directionY = directionY;
    }

    /**
     * Sets the image file.
     * @param filename filename.
     */
    public void setImageFile(String filename) {
        this.image = "/design/" + filename;
    }

    /**
     * Gets the image file.
     * @return image file.
     */
    public String getImageFile() {
        return image;
    }

    /**
     * Sets the radius.
     * @param radius radius.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Gets the radius.
     * @return radius.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the opacity.
     * @param opacity opacity.
     */
    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    /**
     * Gets the opacity.
     * @return opacity.
     */
    public double getOpacity() {
        return opacity;
    }

    /**
     * Gets the start x.
     * @return start x.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Gets the start y.
     * @return start y.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Gets the direction x.
     * @return direction x.
     */
    public int getDirectionX() {
        return directionX;
    }

    /**
     * Gets the direction y.
     * @return direction y.
     */
    public int getDirectionY() {
        return directionY;
    }

    /**
     * Sets the speed.
     * @param millis milliseconds.
     */
    public void setSpeed(int millis) {
        this.speed = millis;
    }

    /**
     * Gets the speed.
     * @return speed.
     */
    public int getSpeed() {
        return speed;
    }
}
