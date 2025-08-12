package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;

/**
 * Implements the Insertion Sort algorithm.
 * Insertion sort is a simple sorting algorithm that builds the final sorted array
 * (or list) one item at a time. It is much less efficient on large lists than
 * more advanced algorithms such as Quick Sort, Merge Sort, or Heap Sort.
 * <p>
 * This implementation assumes the 'Character' class has a getRank() method.
 */
public class InsertionSort implements SortingStrategy {

    @Override
    public void sort(List<Character> units) {
        if (units == null || units.size() <= 1) {
            return;
        }

        int n = units.size();
        for (int i = 1; i < n; i++) {
            Character key = units.get(i);
            int j = i - 1;

            // Move elements of units[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (j >= 0 && units.get(j).getRank() > key.getRank()) {
                units.set(j + 1, units.get(j));
                j = j - 1;
            }
            units.set(j + 1, key);
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
