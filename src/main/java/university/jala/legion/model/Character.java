package university.jala.legion.model;

/**
 * Base abstract class for all military units in the simulation.
 */
public abstract class Character {
    private final int rank;
    private Position position;
    private final char symbol;
    private final int numericRange;

    protected Character(int rank, char symbol, int numericRange) {
        this.rank = rank;
        this.symbol = symbol;
        this.numericRange = numericRange;
    }

    public int getRank() {
        return rank;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getNumericRange() {
        return numericRange;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
