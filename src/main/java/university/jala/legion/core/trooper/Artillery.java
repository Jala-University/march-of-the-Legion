package university.jala.legion.core.trooper;

/**
 * Represents an Artillery unit.
 * Inherits from Troop and provides specific initialization.
 */
public class Artillery extends Troop {
    private static final int RANK = 6;

    public Artillery(String id, char symbol) {
        super(id, RANK, symbol);
    }

    public Artillery(String id, int value) {
        super(id, RANK, value);
    }
}