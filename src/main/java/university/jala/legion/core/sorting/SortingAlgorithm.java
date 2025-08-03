package university.jala.legion.core.sorting;

import university.jala.legion.core.trooper.Troop;
import java.util.List;

/**
 * Interface for sorting algorithms.
 * Adheres to the Open/Closed Principle (OCP), allowing new algorithms
 * to be added without modifying existing code.
 */
public interface SortingAlgorithm {
    /**
     * Sorts a list of troops in place.
     *
     * @param troops The list of troops to be sorted.
     */
    void sort(List<Troop> troops);
}