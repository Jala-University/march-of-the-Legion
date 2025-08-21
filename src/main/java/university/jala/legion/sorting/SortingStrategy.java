package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;

/**
 * The SortingStrategy interface defines the contract for all sorting algorithms.
 * This is part of the Strategy design pattern, allowing different sorting
 * implementations to be used interchangeably.
 */
public interface SortingStrategy {

    /**
     * Sorts a list of military units based on their ranks.
     *
     * @param units The list of units to be sorted.
     */
    void sort(List<Character> units);

    /**
     * Gets the name of the sorting algorithm.
     *
     * @return The name of the algorithm as a String.
     */
    String getName();
}