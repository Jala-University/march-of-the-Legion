package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;

/**
 * Implements the Counting Sort algorithm.
 * Counting sort is an efficient algorithm for sorting a collection of objects
 * according to keys that are small non-negative integers.
 * <p>
 * This implementation assumes the 'Character' class has a getRank() method
 * that returns an integer rank between 1 and 5 (for simplicity and to match the context).
 */
public class CountingSort implements SortingStrategy {

    @Override
    public void sort(List<Character> units) {
        if (units == null || units.size() <= 1) {
            return;
        }

        // Find the maximum rank value. Assuming ranks are small, non-negative integers.
        int maxRank = 0;
        for (Character unit : units) {
            if (unit.getRank() > maxRank) {
                maxRank = unit.getRank();
            }
        }

        int[] count = new int[maxRank + 1];
        Character[] output = new Character[units.size()];

        // Store the count of each character's rank
        for (Character unit : units) {
            count[unit.getRank()]++;
        }

        // Store the cumulative count
        for (int i = 1; i <= maxRank; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = units.size() - 1; i >= 0; i--) {
            int rank = units.get(i).getRank();
            output[count[rank] - 1] = units.get(i);
            count[rank]--;
        }

        // Copy the sorted elements from output array back to the original list
        for (int i = 0; i < units.size(); i++) {
            units.set(i, output[i]);
        }
    }

    @Override
    public String getName() {
        return "Counting Sort";
    }
}
