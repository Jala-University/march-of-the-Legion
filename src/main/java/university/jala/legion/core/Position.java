package university.jala.legion.core;

/**
 * A simple data class representing a position on the battlefield grid.
 * Adheres to SRP by holding only position data.
 */
public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}