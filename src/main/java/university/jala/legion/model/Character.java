package university.jala.legion.model;

import university.jala.legion.model.units.*;

/**
 * Abstract Character class that represents a single military unit.
 * It provides the common properties and methods for all unit types,
 * serving as a base for the specific unit implementations.
 */
public abstract class Character implements Comparable<Character> {
    private final String type;
    protected int rank;
    protected String numericValue;
    protected String characterValue;
    private Position position;

    public Character(String type) {
        this.type = type;
        this.position = null; // Position is set later by the battlefield
    }

    /**
     * Gets the rank of the military unit. Lower rank numbers have higher priority.
     * @return The rank.
     */
    public int getRank() {
        return rank;
    }

    public String getDisplayValue() {
        if ("n".equals(type)) {
            return numericValue;
        } else if ("c".equals(type)) {
            return characterValue;
        }
        return "*"; // Default empty display
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Compares two characters based on their rank.
     * This is the sorting criterion.
     * @param other The other character to compare to.
     * @return A negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Character other) {
        return Integer.compare(this.rank, other.rank);
    }
}