package functionality;

/**
 * Boost.
 */
public class Boost {
    /**
     * Characteristic of the boost.
     */
    private String characteristic;
    /**
     * Image variable.
     */
    private String image;

    /**
     * Constructor.
     * @param goodOrBad "good" or "bad".
     */
    public Boost(String goodOrBad) {
        this.characteristic = goodOrBad;
        setImage();
    }

    /**
     * Gets the characteristic.
     * @return characteristic.
     */
    public String getCharacteristic() {
        return characteristic;
    }

    /**
     * Sets the image.
     */
    public void setImage() {
        if (characteristic.equals("Good")) {
            this.image = "/design/GoodBoost.png";
        } else if (characteristic.equals("Bad")) {
            this.image = "/design/BadBoost.png";
        }
    }
    /**
     * Gets the image.
     * @return image.
     */
    public String getImage() {
        return image;
    }
}
