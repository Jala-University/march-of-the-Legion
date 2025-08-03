package university.jala.legion.core.trooper;

import university.jala.legion.core.Position;

/**
 * Abstract base class representing a military troop.
 * It encapsulates common attributes and methods, following the principle of Abstraction and Inheritance.
 * Implements Comparable for sorting, fulfilling the sorting requirement.
 */
public abstract class Troop implements Comparable<Troop> {
    private final String id;
    private final int rank;
    private char symbol;
    private int value;
    private Position position;

    protected Troop(String id, int rank, char symbol) {
        this.id = id;
        this.rank = rank;
        this.symbol = symbol;
    }

    protected Troop(String id, int rank, int value) {
        this.id = id;
        this.rank = rank;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    /**
     * Compares this troop with another troop based on rank.
     * The sorting order is descending by rank to match the example output.
     *
     * @param other the other troop to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than,
     * equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Troop other) {
        // Sorts in descending order of rank to match the example output.
        return Integer.compare(other.getRank(), this.rank);
    }
}