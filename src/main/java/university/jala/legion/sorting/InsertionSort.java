// Insertion sort implementation.
package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;

/**
 * Implementation of the Insertion Sort algorithm.
 * This is a simple, stable sorting algorithm that is efficient for small datasets.
 */
public class InsertionSort implements SortingStrategy {

    @Override
    public void sort(List<Character> units) {
        int n = units.size();
        for (int i = 1; i < n; ++i) {
            Character key = units.get(i);
            int j = i - 1;

            // Move elements of units[0..i-1] that are greater than key,
            // to one position ahead of their current position.
            while (j >= 0 && units.get(j).compareTo(key) > 0) {
                units.set(j + 1, units.get(j));
                j = j - 1;
            }
            units.set(j + 1, key);
        }
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }
}