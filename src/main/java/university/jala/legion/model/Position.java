// Represents a position on the battlefield grid.
package university.jala.legion.model;

/**
 * The Position class represents a single coordinate on the battlefield grid.
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