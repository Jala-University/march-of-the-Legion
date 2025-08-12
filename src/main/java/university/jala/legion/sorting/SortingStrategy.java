package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;

/**
 * Interface for sorting strategies to arrange military units.
 */
public interface SortingStrategy {
    /**
     * Sorts the given list of units by rank.
     * @param units The list of units to sort
     */
    void sort(List<Character> units);

    /**
     * Gets the name of the sorting algorithm.
     * @return The algorithm name
     */
    String getName();
}
