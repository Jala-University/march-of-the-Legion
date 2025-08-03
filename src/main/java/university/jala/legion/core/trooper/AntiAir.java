package university.jala.legion.core.trooper;

/**
 * Represents an AntiAir unit.
 * Inherits from Troop and provides specific initialization.
 */
public class AntiAir extends Troop {
    private static final int RANK = 7;

    public AntiAir(String id, char symbol) {
        super(id, RANK, symbol);
    }

    public AntiAir(String id, int value) {
        super(id, RANK, value);
    }
}