package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;

/**
 * Implements the Quick Sort algorithm.
 * Quick sort is a highly efficient, in-place sorting algorithm that uses
 * a divide-and-conquer strategy. It works by partitioning an array into
 * two sub-arrays according to a pivot element.
 * <p>
 * This implementation assumes the 'Character' class has a getRank() method.
 */
public class QuickSort implements SortingStrategy {

    @Override
    public void sort(List<Character> units) {
        if (units == null || units.size() <= 1) {
            return;
        }
        quickSort(units, 0, units.size() - 1);
    }

    private void quickSort(List<Character> units, int low, int high) {
        if (low < high) {
            int pi = partition(units, low, high);
            quickSort(units, low, pi - 1);
            quickSort(units, pi + 1, high);
        }
    }

    private int partition(List<Character> units, int low, int high) {
        // Choose the last element as the pivot
        Character pivot = units.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element's rank is less than or equal to the pivot's rank
            if (units.get(j).getRank() <= pivot.getRank()) {
                i++;
                // Swap units[i] and units[j]
                Character temp = units.get(i);
                units.set(i, units.get(j));
                units.set(j, temp);
            }
        }
        // Swap units[i+1] and units[high] (or pivot)
        Character temp = units.get(i + 1);
        units.set(i + 1, units.get(high));
        units.set(high, temp);
        return i + 1;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}
