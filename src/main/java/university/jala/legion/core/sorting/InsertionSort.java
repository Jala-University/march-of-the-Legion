package university.jala.legion.core.sorting;

import university.jala.legion.core.trooper.Troop;
import java.util.List;

/**
 * Implementation of the Insertion Sort algorithm.
 * Adheres to SRP by focusing only on the sorting logic.
 */
public class InsertionSort implements SortingAlgorithm {

    /**
     * Sorts a list of troops using the Insertion Sort algorithm.
     *
     * @param troops The list of troops to be sorted.
     */
    @Override
    public void sort(List<Troop> troops) {
        int n = troops.size();
        for (int i = 1; i < n; ++i) {
            Troop key = troops.get(i);
            int j = i - 1;
            while (j >= 0 && troops.get(j).compareTo(key) > 0) {
                troops.set(j + 1, troops.get(j));
                j = j - 1;
            }
            troops.set(j + 1, key);
        }
    }
}