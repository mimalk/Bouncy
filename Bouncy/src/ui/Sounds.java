package ui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Soundtrack and sound effects for the game.
 */
public class Sounds {
    /**
     * Return the game's soundtrack.
     * @return Soundtrack.
     */
    public static MediaPlayer getSoundtrack() {
        //Resource: orangefreesounds (music by: Alexander Blu)
        Media sound = new Media(Sounds.class.getClassLoader().getResource("design/Soundtrack.mp3").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        return mediaPlayer;
    }

    /**
     * Play the popping sound.
     */
    public static void playPoppingSound() {
        //Resource: orangefreesounds (music by: Alexander)
        Media sound = new Media(Sounds.class.getClassLoader().getResource("design/PoppingSound.mp3").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
