package functionality;

/**
 * Paddle.
 */
public class Paddle {
    /**
     * Start x.
     */
    private int startX;
    /**
     * Start y.
     */
    private int startY;
    /**
     * Width.
     */
    private int width;
    /**
     * Height.
     */
    private int height;
    /**
     * Image.
     */
    private String image;

    /**
     * Constructor.
     * @param startX start x.
     * @param startY start y.
     * @param height height.
     */
    public Paddle(int startX, int startY, int height) {
        this.startX = startX;
        this.startY = startY;
        this.height = height;
    }

    /**
     * Sets the width.
     * @param width width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the width.
     * @return width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the image's file.
     * @param filename file name.
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

    /***
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
     * Gets the height.
     * @return height.
     */
    public int getHeight() {
        return height;
    }
}
