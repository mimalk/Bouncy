package functionality;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Level class.
 */
public class Level {
    /**
     * File name.
     */
    private String fileName;
    /**
     * List of the rows in the file.
     */
    private List<String> rows;
    /**
     * Scanner.
     */
    private Scanner scanner;
    /**
     * Current level's number.
     */
    private int currentLevel;

    /**
     * Constructor.
     * @param number level number.
     */
    public Level(int number) {
        this.currentLevel = number;
        this.fileName = "Level" + Integer.toString(currentLevel);
        this.rows = new ArrayList<>();
        Path path = Paths.get("Bouncy", "src", "functionality", "levelDesigns", fileName);
        try {
            this.scanner = new Scanner(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        readRows();
    }

    /**
     * Gets the current level number.
     * @return current level number.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Reads the rows from the file.
     */
    public void readRows() {
            while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.charAt(0) != '/') {
                rows.add(line);
            }
        }
    }

    /**
     * Gets the list of the rows in the file.
     * @return list of rows.
     */
    public List<String> getRows() {
        return rows;
    }
}

