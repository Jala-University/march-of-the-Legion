package university.jala.legion.core.trooper;

/**
 * Represents an Engineer unit.
 * Inherits from Troop and provides specific initialization.
 */
public class Engineer extends Troop {
    private static final int RANK = 5;

    public Engineer(String id, char symbol) {
        super(id, RANK, symbol);
    }

    public Engineer(String id, int value) {
        super(id, RANK, value);
    }
}